package DasignPattern11;

/**
 * 单例模式
 * 单例模式其实在之前的课程中已经演示过很多次了 这也是使用频率非常高的一种模式
 *
 * 那么 什么是单例模式呢? 顾名思义 单例那么肯定就是只有一个实例对象 在我们的整个程序中同一个类始终只会有一个对象来进行操作
 * 比如数据库连接类 实际上我们只需要创建一个对象或是直接使用静态方法就可以了 没必要去创建多个对象
 *
 * 这里还是还原一下我们之前使用的简单单例模式:
 *                  public class Singleton {
 *
 *                      private final static Singleton INSTANCE = new Singleton(); // 用于引用全局为一的单例对象 在一开始就创建
 *
 *                      private Singleton() {} // 不允许随便new 需要对象直接找getInstance
 *
 *                      public static Singleton getInstance() { // 获取全局唯一的单例对象
 *                          return INSTANCE;
 *                      }
 *
 *                  }
 *
 * 这样 当我们需要获取此对象时 只能通过getInstance()来获取唯一的对象:
 *                  public static void main(String[] args) {
 *                      Singleton singleton = Singleton.getInstance();
 *                  }
 *
 * 当然 单例模式除了这种写法之外 还有其他写法 这种写法被称为饿汉式单例 也就是说在一开始类型加载时就创建好了 我们来看看另一种写法——懒汉式:
 *                  public class Singleton2 {
 *
 *                      private static Singleton2 INSTANCE; // 在一开始先不进行对象创建
 *
 *                      private Singleton2() {}; // 不用多说了吧
 *
 *                      public static Singleton2 getInstance() { // 将对象的创建延后到需要时再进行
 *
 *                          if (INSTANCE == null) { // 如果实例为空 那么就进行创建 不为空说明已经创建过了 那么就直接返回
 *                              INSTANCE = new Singleton2();
 *                          }
 *                          return INSTANCE;
 *
 *                      }
 *
 *                  }
 *
 * 可以看到 懒汉式就真的是条懒狗 你不去用它 它是不会给你提前准备单例对象的(延迟加载 懒加载)
 * 当我们需要获取对象时 才会进行检查并创建 虽然饿汉式和懒汉式写法不同 但是最后都是成功实现了单例模式
 *
 * 不过 这里需要特别提醒一下 由于懒汉式是在方法中进行的初始化 在多线程环境下 可能会出现问题(建议学完JUC篇视频教程再来观看)
 * 大家可以试想一下 如果这个时候有多个线程同时调用了getInstance()方法 那么会出现什么问题呢?
 *
 *                              INSTANCE = null                    INSTANCE被赋值三次
 *                      [线程1] -----获取单例-----> [判断到没有实例化] -----对象创建-----> [获取对象]
 *                      [线程2] -----获取单例-----> [判断到没有实例化] -----对象创建-----> [获取对象]
 *                      [线程3] -----获取单例-----> [判断到没有实例化] -----对象创建-----> [获取对象]
 *
 * 可以看到 在多线程环境下 如果三条线程同时调用getInstance()方法 会同时进行INSTANCE = null的判断
 * 那么此时由于确实还没有进行任何实例化 所以导致三条线程全部判断为true (而饿汉式由于在类加载时就创建完成 不会存在这样的问题)
 * 此时问题就来了 我们既然要使用单例模式 那么肯定只希望对象只被初化一次的 但是现在由于多线程的机制 导致对象被多次创建
 *
 * 所以 为了避免线程安全问题 针对于懒汉式单例 我们还得进行一些改进:
 *                  public static synchronized Singleton2 getInstance() { // 方法必须添加synchronized关键字加锁
 *
 *                      if (INSTANCE == null) {
 *                          INSTANCE = new Singleton2();
 *                      }
 *                      return INSTANCE;
 *
 *                  }
 *
 * 既然多个线程要调用 那么我们就直接加一把锁 在方法上添加synchronized关键字即可 这样同一时间只能有一个线程进入了
 * 虽然这样简单粗暴 但是在高并发的情况下 效率肯定是比较低的 我们来看看如何进行优化:
 *                  static Singleton2 getInstance() {
 *
 *                      if (INSTANCE == null) {
 *                          synchronized (Singleton2.class) { // 实际上只需要对赋值这一步进行加锁即可
 *                              INSTANCE = new Singleton2();
 *                          }
 *                      }
 *                      return INSTANCE;
 *
 *                  }
 *
 * 不过这样还不完美 因为这样还是有可能多个线程同时判断为null而进入等锁的状态 所以 我们还得加一层判断:
 *                  static Singleton2 getInstance() {
 *
 *                      if (INSTANCE == null) {
 *                          synchronized (Singleton2.class) {
 *                              if (INSTANCE == null) INSTANCE = new Singleton2(); // 内层还要进行一次检查 双重检查锁定
 *                          }
 *                      }
 *                      return INSTANCE;
 *
 *                  }
 *
 * 不过我们还少考虑了一样内容 其实IDEA此时应该是给黄标了
 *
 * 可以看到 这种情况下 IDEA会要求我们添加一个volatile给INSTANCE 各位还记得这个关键字有什么作用吗? 没错
 * 我们还需要保证INSTANCE在线程之间的可见性 这样当其他线程进入后才会拿INSTANCE由其他线程更新的最新值去判断 这样 就差不多完美了
 *
 * 那么 有没有一种更好的 不用加锁的方式也能实现延迟加载的写法呢? 我们可以使用静态内部类:
 *                  public class Singleton {
 *
 *                      private Singleton() {}
 *
 *                      private static class Holder { // 由静态内部类持有单例对象 但是根据类加载特性 我们仅使用Singleton类时 不会对静态内部类进行初始化
 *                          private final static Singleton INSTANCE = new Singleton();
 *                      }
 *
 *                      public static Singleton getInstance() { // 只有真正使用内部类时 才会进行类初始化
 *                          return Holder.INSTANCE; // 直接获取内部类中的
 *                      }
 *
 *                  }
 *
 * 这种方式显然最完美的懒汉式解决方案 没有进行任何的加锁操作 也能保证线程安全 不过要实现这种写法 跟语言本身也有一定的关联 并不是所有的语言都支持这种写法
 */
public class Main {

    public static void main(String[] args) {

        Singleton1 singleton = Singleton1.getInstance();

    }

}
