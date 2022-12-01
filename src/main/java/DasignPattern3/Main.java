package DasignPattern3;

/**
 * 里氏替换原则
 * 里氏替换原则(Liskov Substitution Principle) 是对子类型的特别定义
 * 它由芭芭拉-利斯科夫(Barbara Liskov)在1987年在一次会议是名为"数据的抽象与层次"的演说中首先提出
 *
 *      所有引用基类的地方必须能透明地使用其子类的对象
 *
 * 简单的说就是 子类可以扩展父类的功能 但不能改变父类原有的功能:
 *      > 子类可以实现父类的抽象方法 但不能覆盖父类的非抽象方法
 *      > 子类型可以增加加自己特有的方法
 *      > 当子类的方法重载父类的方法时方法的前置条件(即方法的输入/入参)要比父类方法的输入参数更宽松
 *      > 当子类的方法实现父类的方法时(重写/重载或实现抽象方法)方法的后置条件(即方法的输出/返回值)要比父类更严格或与父类一样
 *
 * 比如我们下面的例子:
 *                  public abstract class Coder {
 *
 *                      public void coding() {
 *                          System.out.println("我会打代码");
 *                      }
 *
 *                      class JavaCoder extends Coder { // 子类除了打代码之外 还会打游戏
 *                          public void game() {
 *                              System.out.println("艾欧里亚最强王者已上号");
 *                          }
 *                      }
 *
 *                  }
 *
 * 可以看到JavaCoder虽然继承自Coder 但是并没有对父类方法进行重写 并且还在父类的基础上进行额外的扩展 符号里氏替换原则 但是我们再来看下面的这个例子:
 *                  public abstract class Coder {
 *
 *                      public void coding() {
 *                          System.out.println("我会打代码");
 *                      }
 *
 *                      class JavaCoder extends Coder {
 *                          public void game() {
 *                              System.out.println("艾欧里亚最强王者已上号");
 *                          }
 *
 *                          // 这里我们对父类的行为进行了重写 现在它不再具备父类原本的能力了
 *                          @Override
 *                          public void coding() {
 *                              System.out.println("我寒窗苦读十六年 到最后还不如培训班三个月出来的程序员");
 *                              System.out.println("想来想去 房子车子结婚彩礼 为什么这辈子要活的这么累呢?");
 *                              System.out.println("难道来到这世间走这一遭就为了花一辈子时间买个房子吗? 一个人不是也能活的轻松快乐吗?");
 *                              System.out.println("摆烂了 啊对对对");
 *                              // 好了 emo结束 继续卷吧 人生因奋斗而美丽 这个世界虽然满目疮痍 但是还是有很多美好值得期待
 *                          }
 *                      }
 *
 *                  }
 *
 * 可以看到 现在我们对父类的方法进行了重写 显然 父类的行为已经被我们给覆盖了 这个子类已经不具备父类的原本的行为 很显然违背了里氏替换原则
 *
 * 要是程序员连敲代码都不会了 还能叫做程序员吗?
 *
 * 所以 对于这种情况 我们不需要再继承自Coder了 我们可以提升一下 将此行为定义到People中:
 *                  public abstract class Coder {
 *
 *                      public abstract void coding(); // 这个行为还是定义出来 但是不实现
 *
 *                      class JavaCoder extends Coder {
 *                          public void game() {
 *                              System.out.println("艾欧里亚最强王者已上号");
 *                          }
 *
 *                          public void coding() {
 *                              System.out.println("摆烂了 啊对对对");
 *                          }
 *                      }
 *
 *                  }
 *
 * 里氏替换也是实现开闭原则的重要方式之一
 */
public class Main {

    public static void main(String[] args) {

    }

}
