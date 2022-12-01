package DasignPattern25;

/**
 * 中介者模式
 * 在早期 我们想要和别人进行语音聊天 一般都是通过打电话的方式 我通过拨打他人的电话号码 来建立会话 不过这样有一个问题
 * 不过这样有一个问题 比如我们现在想要通知3个人某件事情 那么我记得依次给三个人打电话 甚至还会遇到一种情况
 * 就是我们没有某个人的电话号码 但是其他人有 这时还需要告知整这个人并进行转告 就很麻烦
 *
 * 但是现在我们有了Facetime 有了微信 我们可以同时让多个人参与到群通话中进行群聊 这样我们就不需要一个一个单独进行通话或是转达了
 * 实际上正是依靠了一个中间商给我们提供了进行群体通话的平台 我们才知道哪里有可以租的房子呢? 于是我们就会上各大租房APP上去找房源
 * 同样的 如果我们现在有房子需要出租 我们也不知道谁会想租房子 同样的我们也会把房子挂在租房APP上展示 而当我们去租房时或是出租时
 * 就会有一个称为中介的人来跟我们对接 实际上也是一种中介的模式
 *
 * 在我们的程序中 可能会出现很多的对象 但是这些对象之间的相互调用关系错综复杂 可能一个对象要做什么事情就得联系好几个对象
 *
 * 但是如果我们在这中间搞一个中间人 这样当我们要来联系其他人时 一律找中介就可以了 中介存储了所有人的联系方式 这样就不会像上面一样乱成一团了 这里我们就以房产中介的例子来编写:
 *                  public class Mediator { // 房产中介
 *
 *                      private final Map<String, User> userMap = new HashMap<>(); // 在出售的房子需要存储一下
 *
 *                      public void register(String address, User user) { // 出售房屋的人 需要告诉中介他的房屋在哪里
 *                          userMap.put(address, user);
 *                      }
 *
 *                      public User find(String address) { // 通过此方法来看看有没有对应的房源
 *                          return userMap.get(address);
 *                      }
 *
 *                  }
 *
 * 接着就是用户了 用户有两种角色 一种是租房 一种是出租:
 *                  public class User { // 用户可以是出售房屋的一方 也可以是寻找房屋的一方
 *
 *                      String name;
 *                      String tel;
 *
 *                      public User(String name, String tel) {
 *                          this.name = name;
 *                          this.tel = tel;
 *                      }
 *
 *                      public User find(String address, Mediator mediator) { // 找房子的话 需要一个中介和你具体想找的地方
 *                          return mediator.find(address);
 *                      }
 *
 *                      @Override
 *                      public String toString() {
 *                          return name + "(电话: " + tel + ")";
 *                      }
 *
 *                  }
 *
 * 现在我们来测试一下:
 *                  public static void main(String[] args) {
 *
 *                      User user0 = new User("刘女士", "10086"); // 出租人
 *                      User user1 = new User("李先生", "10010"); // 找房人
 *                      Mediator mediator = new Mediator(); //
 *
 *                      mediator.register("成都市武侯区天府五街白马程序员", user0);
 *                      User user = user1.find("成都市武侯区天府五街下硅谷", mediator);
 *                      if (user == null) System.out.println("没有找到对应的房源");
 *
 *                      user = user1.find("成都市武侯区天府路五街白马程序员", mediator);
 *                      System.out.println(user);
 *
 *                  }
 *
 * 中介者模式优化了原有的复杂多对多关系 而是将其简化为一对多的关系 更容易理解一些
 */
public class Main {

    public static void main(String[] args) {

        User user0 = new User("刘女士", "10086");
        User user1 = new User("李先生", "10010");
        Mediator mediator = new Mediator();

        mediator.register("成都市武侯区天府五街白马程序员", user0);
        User user = user1.find("成都市武侯区天府五街下硅谷", mediator);
        if (user == null) System.out.println("没有找到对应的房源");

        user = user1.find("成都市武侯区天府路五街白马程序员", mediator);
        System.out.println(user);

    }

}
