package DasignPattern19;

/**
 * 享元模式
 * 最后我们来看看享元模式(Flyweight) 那么这个"享元"代表上面意思呢? 我们先来看看下面的问题:
 *                  String str1 = "abcdefg";
 *                  String str2 = "abcd";
 *
 * 我们发现上面的例子中 两个字符串虽然长短不同 但是却包含了一段相同的部分 那么现在为如果要对内存进行优化:
 *                  String str1 = "efg"; //str1包含str2 所以我们可以去掉重复的部分 当需要原本的str1时 再合在一起
 *                  String str2 = "abcd";
 *                  System.out.println("str1 = " + str2 + str1);
 *
 * 而享元模式就是这个意思 我们可以将那些重复出现的内容作为共享部分取出 这样当我们拥有大量对象时 我们把其中共同的部分抽取出来 由于提取的部分是多个对象共享只有一份
 * 那么就可以减轻内存的压力 包括我们的围棋 实际上我们只需要知道棋盘上的各个位置是黑棋还是白棋 实际上没有必要创建很多个棋子对象 我们需要去复用一个黑棋和一个白棋子对象即可
 *
 * 比如现在我们有两个服务 但是他们都需要使用数据库工具类来操作 实际上这个工具类没必要创建多个
 * 我们这时就可以使用享元模式 让数据库工具类作为享元模式类 通过享元模式来提供一个共享的数据库工具类:
 *                  public class DBUtil {
 *
 *                      public void selectDB() {
 *                          System.out.println("我是数据库操作...");
 *                      }
 *
 *                  }
 *
 *                  public class DBUtilFactory {
 *
 *                      private static final DBUtil UTIL = new DBUtil(); // 享元对象被存放在工厂中
 *
 *                      public static DBUtil getFlyweight() { // 获取享元对象
 *                          return UTIL;
 *                      }
 *
 *                  }
 *
 * 最后当我们需要使用享元模式对象时 直接找享元模式实现 实际上我们一开始举例的String类 也在使用享元模式进行优化 比如下面的代码:
 *                  public class UserService { // 用户服务
 *
 *                      public void service() {
 *                          DBUtil util = DBUtilFactory.getFlyweight(); // 通过享元工厂拿到DBUtil对象
 *                          util.selectDB(); // 该干嘛干嘛
 *                      }
 *
 *                  }
 *
 * 当然 这只是简单享元模式实现 实际上我们一开始举例的String类 也在使用享元模式进行优化 比如下面的代码:
 *                  public static void main(String[] args) {
 *
 *                      String str1 = "abcd";
 *                      String str2 = "abcd";
 *                      String str3 = "ab" + "cd";
 *                      System.out.println(str1 == str2);
 *                      System.out.println(str1 == str3); // 猜猜这三个对象是不是都是同一个?
 *
 *                  }
 *
 * 虽然我们这里定义了三个字符串 但是我们发现 这三个对象指向的都是同一个对象 这是为什么呢? 实际上这正是Java语言实现了数据的共享 想要了解具体实现请前往JVM篇
 */
public class Main {

    public static void main(String[] args) {

        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = "ab" + "cd";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

    }

}
