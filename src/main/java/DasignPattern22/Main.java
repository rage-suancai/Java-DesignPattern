package DasignPattern22;

/**
 * 责任链模式
 * 责任链模式也非常好理解 比如我们的钉钉审批 实际上就是一条流水线一样的操作 由你发起申请 然后经过多个部门主管审批
 * 最后才能通过 所以你的申请表相当于是在一条注责任链上传递 当然除了这样的直线型责任链之外 还有环形 树形等
 *
 *                              发起人                 发起人
 *                                |                     |
 *                             财务专员                财务专员
 *                                |                     |
 *                             部门主管                财务总监
 *                                |                     |
 *                             部门经理                总经理
 *
 * 实际上我们之前也遇到过很多种责任链 比如JavaWeb中学习的File过滤器 正是采用的责任链模式通过将请求一级一级不断向下传递 来对我们所需的请求进行过滤和处理
 *
 *                             请求 -----> Filter -----> Filter -----> Filter -----> Servlet
 *
 * 这里我们就使用责任链模式来模拟一个简单的面试过程 我们面试也是一面二面三面这样的走的流程 这里我们先设计一下责任链上的各个处理器:
 *                  public abstract class Handler {
 *
 *                      protected Handler successor; // 这里我们就设计责任链以单链表形式存在 这里存放后继节点
 *
 *                      public Handler connect(Handler successor) { // 拼接后续节点
 *
 *                          this.successor = successor;
 *                          return successor; // 这里返回后继节点 方便我们一会链式调用
 *
 *                      }
 *
 *                      public void handler() {
 *
 *                          this.doHandle(); // 由不同的子类实现具体处理过程
 *                          Optional
 *                                  .ofNullable(successor)
 *                                  .ifPresent(Handler::handler); // 责任链上如果还有后继节点 就继续向下传递
 *
 *                      }
 *
 *                      public abstract void doHandle(); // 结合上一节课学习的模板方法 交给子类实现
 *
 *                  }
 *
 * 因为面试有很多轮 所以我们这里创建几个处理器的实现:
 *                  public class FirstHandler extends Handler{
 *
 *                      @Override
 *                      public void doHandle() {
 *                          System.out.println("============= 白马程序员一面 ==========");
 *                          System.out.println("1. 谈谈你对static关键字的理解? ");
 *                          System.out.println("2. 内部类可以调用外部的数据吗? 如果是静态的呢？");
 *                          System.out.println("3. hashCode()方法是所有的类都有? 默认返回的是什么呢?");
 *                      }
 *
 *                  }
 *
 *                  public class SecondHandler extends Handler {
 *
 *                      @Override
 *                      public void doHandle() {
 *                          System.out.println("============= 白马程序员二面 ==========");
 *                          System.out.println("1. 如果我们自己创建一个java.lang包并且编写一个String类 能否实现覆盖JDK默认的?");
 *                          System.out.println("2. HashMap的负载因子有什么作用? 变化规律是什么?");
 *                          System.out.println("3. 线程池的运作机制是什么?");
 *                          System.out.println("4. ReentrantLock公平锁和非公平锁的区别是什么?");
 *                      }
 *
 *                  }
 *
 *                  public class ThirdHandler extends Handler {
 *
 *                      @Override
 *                      public void doHandle() {
 *                          System.out.println("============= 白马程序员三面 ==========");
 *                          System.out.println("1. synchronized关键字了解吗? 如何使用? 底层是如何实现的?");
 *                          System.out.println("2. IO和NIO的区别在哪里? NIO三大核心组件?");
 *                          System.out.println("3. TCP握手和挥手流程? 少一次握手可以吗？为什么?");
 *                          System.out.println("4. 操作系统中PCB是做什么的? 运行机制是什么?");
 *                      }
 *
 *                  }
 *
 * 这样我们就编写好了每一个轮的面试流程 现在我们就可以构建一个责任链了:
 *                  public static void main(String[] args) {
 *
 *                      Handler handler = new FirstHandler(); // 一面首当其冲
 *                      handler
 *                              .connect(new SecondHandler()) // 继续连接二面和三面
 *                              .connect(new ThirdHandler());
 *                      handler.handler(); // 开始面试
 *
 *                  }
 *
 * 可以看到最后结果也是按照我们的责任链来进行的
 */
public class Main {

    public static void main(String[] args) {

        Handler handler = new FirstHandler();
        handler
                .connect(new SecondHandler())
                .connect(new ThirdHandler());
        handler.handler();

    }

}
