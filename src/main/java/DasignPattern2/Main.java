package DasignPattern2;

/**
 * 开闭原则
 * 开闭原则(Open Close Principle) 也是重要的面向对象设计原则
 *
 *      软件实体应当对扩展开放 对修改关闭
 *
 * 一个软件实体 比如类 模块和函数应该对扩展开放 对修改关闭 其中 对扩展开放是针对提供方来说的 对修改关闭是针对调用方来说的
 *
 * 比如我们的程序员分为Java程序员 C#程序员 C艹程序员 PHP程序员 前端程序员等 而他们要做的都是去打代码 而具体如何打代码是根据不同语言的程序员来决定的
 * 我们可以将程序员打代码这一个行为抽象成一个统一的接口或是抽象类 这样我们就满足了开闭原则的第一个要求: 对扩展开放 不同的程序员可以自由地决定他们该如何进行编程
 * 而具体哪个程序员使用上面语言怎么编程 是自己在负责 不需要其他程序员干涉 所以满足第二个要求: 对修改关闭 比如:
 *                  public abstract class Coder {
 *
 *                      public abstract void coding();
 *
 *                      static class JavaCoder extends Coder {
 *                          @Override
 *                          public void coding() {
 *                              System.out.println("Java太卷了T_T 快去学Go吧");
 *                          }
 *                      }
 *
 *                      class PHPCoder extends Coder {
 *                          @Override
 *                          public void coding() {
 *                              System.out.println("PHP是世界上最好的语言");
 *                          }
 *                      }
 *
 *                      class C艹Coder extends Coder {
 *                          @Override
 *                          public void coding() {
 *                              System.out.println("笑死 Java再牛逼底层不还得找我?");
 *                          }
 *                      }
 *
 *                  }
 *
 * 通过提供应该Coder抽象类 定义出编程的行为 但是不进行实现 而是开放给其他其他具体类型的程序员来实现 这样就可以根据不同的业务进行灵活扩展了 具有较好的延续性
 *
 * 不过 回顾我们这一路的学习 好像处处都在使用开闭原则
 */
public class Main {

    public static void main(String[] args) {

    }

}
