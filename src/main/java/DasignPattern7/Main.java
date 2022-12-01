package DasignPattern7;

import java.io.IOException;
import java.net.Socket;

/**
 * 迪米特法则
 * 迪米特法则(Law of Demeter)又称最少知识原则 是对程序内部数据交互的限制
 *
 *      每个软件单位对其他单位都只有最少的知识 而且局限于那些与本单位密切相关的软件单位
 *
 * 简单来说就是 一个类/模块对其他的类/模块有越少的交互越好 当一个类发生改动 那么 与其相关的类(比如用到此类啥方法的类)
 * 需要尽可能少的受到影响(比如修改了方法名 字段名等 可能其他用到这些方法或是字段的类也需要跟着修改) 这样我们在维护项目的时候会更加轻松一些
 *
 * 其实说白了 还是降低耦合度 我们还是来看一个例子:
 *                  public class Main {
 *
 *                      public static void main(String[] args) throws IOException {
 *
 *                          Socket socket = new Socket("localhost", 8080); // 假设我们当前的程序需要进行网络通信
 *                          Test test = new Test();
 *                          test.test(socket); // 现在需要执行test方法来做一些事情
 *
 *                      }
 *
 *                      static class Test {
 *                          // 比如test方法需要得到我们当前Socket连接的本地地址
 *                          public void test(Socket socket) {
 *                              System.out.println("IP地址为: " + socket.getLocalAddress());
 *                          }
 *
 *                      }
 *
 *                  }
 *
 * 可以看到 虽然什么这种写法没有问题 我们直接提供一个Socket对象 然后再由test方法来取出IP地址 但是这样显然违背了迪米特法则
 * 实际上这里的test方法只需要一个IP地址即可 我们完全可以直接传入一个字符串 而不是整个Socket对象 我们需要保证与其他类的交互尽可能的少
 *
 * 就像我们在餐厅吃完了饭 应该是我们自己扫码付款 而不是直接把手机交给老板来帮你操作付款
 *
 * 要是某一天 Socket类中的这些方法发生修改 那我们就得连带着去修改这些类 很麻烦
 *
 * 所以 我们来改进改进:
 *                  public static void main(String[] args) throws IOException {
 *
 *                      Socket socket = new Socket("localhost", 8080);
 *                      Test test = new Test();
 *                      test.test(socket.getLocalAddress().getHostAddress());
 *
 *                  }
 *
 *                  static class Test {
 *
 *                      public void test(String str) {
 *                          System.out.println("IP地址为: " + str);
 *                      }
 *
 *                  }
 *
 * 这样 类与类之间的耦合度再次降低
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8080);
        Test test = new Test();
        test.test(socket.getLocalAddress().getHostAddress());

    }

    static class Test {

        public void test(String str) {
            System.out.println("IP地址为: " + str);
        }

    }

}
