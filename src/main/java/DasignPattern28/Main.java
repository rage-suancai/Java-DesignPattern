package DasignPattern28;

/**
 * 状态模式
 * 在标准大气压下 水在0度时会结冰变成固态 在--100之间时 会呈现液态 100度以上会变成气态 水这种物质在不同的温度下呈现出不同的状态
 * 而我们的对象 可能也会像这样存在很多种状态 甚至在不同的状态会有不同的行为 我们就可以通过状态模式来实现
 *
 * 我们来设计一个学生类 然后学生的学习方法会根据状态不同而发生改变 我们先设计一个状态枚举:
 *                  public enum State { // 状态直接使用枚举定义
 *                      NORMAL, LAZY
 *                  }
 *
 * 接着我们来编写一个学生类:
 *                  public class Student {
 *
 *                      private State state; // 使用一个成员来存储状态
 *
 *                      public void setState(State state) {
 *                          this.state = state;
 *                      }
 *
 *                      public void study() {
 *                          switch (state) { // 根据不同的状态 学习方法会有不同的结果
 *                              case LAZY : System.out.println("只要我不努力 老板就别想过上想要的生活 开摆"); break;
 *                              case NORMAL: System.out.println("拼搏百天 我要上清华大学"); break;
 *                          }
 *                      }
 *
 *                  }
 *
 * 我们来看看 在不同的状态下 是否学习会出现不同的效果:
 *                  public static void main(String[] args) {
 *
 *                      Student student = new Student();
 *                      student.setState(State.NORMAL); // 先正常模式
 *                      student.study();
 *                      student.setState(State.LAZY); // 开启摆烂模式
 *                      student.study();
 *
 *                  }
 *
 * 状态模式更加强调调当前的对象所处的状态 我们需要根据对象不同的状态决定其他的处理逻辑
 */
public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.setState(State.NORMAL);
        student.study();
        student.setState(State.LAZY);
        student.study();

    }

}
