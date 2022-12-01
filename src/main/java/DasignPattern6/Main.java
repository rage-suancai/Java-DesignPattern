package DasignPattern6;

/**
 * 合成复用原则
 * 合成复用原则(Composite Reuse Principle)的核心就是委派
 *
 *      优先使用对象组合 而不是通过继承来达到复用的目的
 *
 * 在一个新的对象里面使用一些已有的对象 使之成为新对象的一部分 新的对象通过向这些对象的派达到复用已有功能的目的
 * 实际上我们在考虑将某个类通过继承关系在子类得到父类已经实现的方法之外(比如A类实现了连接数据库的功能 恰巧B类中也需要
 * 我们就可以通过继承来获得A已经实现好的连接数据库的功能 这样就能直接复用A中已经写好的逻辑) 我们应该优先地去考虑使用合成方式来实现复用
 *
 * 比如下面这个例子:
 *                  public class A {
 *
 *                      public void connectDatabase() {
 *                          System.out.println("我是连接数据库操作");
 *                      }
 *
 *                  }
 *
 *                  public class B extends A { // 直接通过继承的方式 得到A的数据库连接逻辑
 *
 *                      public void test() {
 *                          System.out.println("我是B的方法 我也需要连接数据库");
 *                          connectDatabase(); // 直接调用父类方法就行
 *                      }
 *
 *                  }
 *
 * 虽然这样看起来没啥毛病 但是还是存在我们之前说的那个问题 耦合度太高了
 *
 * 可以看到通过继承的方式实现复用 我们是将类B直接指定继承自类A的 那么如果有一天 由于业务的更改 我们的数据库连接操作
 * 不再由A来负责 而是由新来的C去负责 那么这个时候 我们就不得不将需要复用A中方法的子类全部进修改 很显然这样是费时费力的
 *
 * 并且还有一个问题就是 通过继承子类会得到一些父类中的实现细节 比如某些字段或是方法 这样直接暴露给子类 并不安全
 *
 * 所以 当我们需要实现复用时 可以优先考虑以下操作:
 *                  public class A {
 *
 *                      public void connectDatabase() {
 *                          System.out.println("我是连接数据库操作");
 *                      }
 *
 *                  }
 *
 *                  public class B { // 不进行继承 而是在用的时候给我一个A 当然也可以抽象成一个接口 更加灵活
 *
 *                      public void test(A a) {
 *                          System.out.println("我是B的方法 我也需要连接数据库");
 *                          a.connectDatabase(); // 在通过传入的对象A去执行
 *                      }
 *
 *                  }
 *
 * 或是:
 *                  public class A {
 *
 *                      public void connectDatabase() {
 *                          System.out.println("我是连接数据库操作");
 *                      }
 *
 *                  }
 *
 *                  public class B {
 *
 *                      A a;
 *                      public B(A a) { // 在构造时就指定好
 *                          this.a = a;
 *                      }
 *
 *                      public void test() {
 *                          System.out.println("我是B的方法 我也需要连接数据库");
 *                          a.connectDatabase(); // 也是通过对象A去执行
 *                      }
 *
 *                  }
 *
 * 通过对象之间的组合 我们就大大降低了类之间的耦合度 并且A的实现细节我们也不会直接得到了
 */
public class Main {

    public static void main(String[] args) {



    }

}
