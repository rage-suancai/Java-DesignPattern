package DasignPattern26;

/**
 * 备忘录模式
 *      2021年10月1日下午 河南驻马店的一名13岁女中学生 因和同学发生不愉快喝下半瓶百草枯
 *      10月5日 抢救四天情况恶化 家属泣不成声称"肺部一个小时一变"
 *      10月6日下午 据武警河南省总队医院消息 "目前女孩仍在医院救治"
 *
 * 喝下百草枯 会给你后悔的时间 但是不会给你后悔的机会(百草枯含有剧毒物质 会直接导致肺部纤维化 这是不可逆的 一般死亡过程在一周左右
 * 即使家里花了再多的钱 接受了再多的治疗 也无法逆转这一过程)相信如果再给这位小女孩一次机会 回到拿起百草枯的那一刻 一定不会再冲动地喝下了吧
 *
 * 备忘录模式 就为我们的软件提供了一个可回溯的时间节点 可能我们程序在运行过程中某一步出现了错误 这时我们就可以回到之前的某个被保存的节点上重新来过(就像艾克的大招)
 * 我们平时编写文本的时候 当我们编辑出现错误时 就需要撤回 而我们只需要按下Ctrl+z就可以回到上一步 这样的大大方便来我们的文本编辑
 *
 * 其实备忘录模式也可以应用到我们的程序中 如果你学习过安卓开放 安卓程序在很多情况下都会重新加载Activity 实际上安卓中Activity
 * 的onSaveInstanceState和onRestoreInstanceState 就是用到了备忘录模式 分别用于保存和恢复 这样就算重新加载也可以恢复到之前的状态
 *
 * 这里我们就和模拟一下对象的状态保存:
 *                  public class Student {
 *
 *                      private String currentWork; // 当前正在做的事情
 *                      private int percentage; // 当前的工作完成百分比
 *
 *                      public void work(String currentWork) {
 *                          this.currentWork = currentWork;
 *                          this.percentage = new Random().nextInt(100);
 *                      }
 *
 *                      @Override
 *                      public String toString() {
 *                          return "我现在正在做: " + currentWork + "(进度: " + percentage + "%)";
 *                      }
 *
 *                  }
 *
 * 接着我们需要保存它在某一时刻的状态 我们来编写一个状态保存类:
 *                  public class State {
 *
 *                      final String currentWork;
 *                      final int percentage;
 *
 *                      State (String currentWork, int percentage) { // 仅开放给同一个包下的student类使用
 *                          this.currentWork = currentWork;
 *                          this.percentage = percentage;
 *                      }
 *
 *                  }
 *
 * 接着我们来将状态的保存和恢复操作都实现一下:
 *                  public class Student {
 *
 *                      ...
 *
 *                      public State save() {
 *                          return new State(currentWork, percentage);
 *                      }
 *
 *                      public void restore(State state) {
 *                          this.currentWork = state.currentWork;
 *                          this.percentage = state.percentage;
 *                      }
 *
 *                      ...
 *
 *                  }
 *
 * 现在我们来测试一下吧:
 *                  public static void main(String[] args) {
 *
 *                      Student student = new Student();
 *                      student.work("学Java"); // 开始学Java
 *                      System.out.println(student);
 *                      State savedStateJava = student.save(); // 保存一下当前的状态
 *
 *                      student.work("打电动"); // 刚打B站播放视频 学一半开始摆烂了
 *                      System.out.println(student);
 *
 *                      student.restore(savedStateJava); // 两级反转 回到上一个保存的状态
 *                      System.out.println(student); // 回到学Java的状态
 *
 *                  }
 *
 * 可以看到 虽然在学习Java的过程中 中途摆烂了 但是我们可以时光倒流 回到还没开始摆烂的时候 继续学习Java:
 *                  我现在正在学Java(进度: 84%)
 *                  我现在正在打电动(进度: 56%)
 *                  我现在正在学Java(进度: 84%)
 *
 * 不过备忘录模式为了去保存对象的状态 会占用大量的资源 尤其是那种属性很多的对象 我们需要合理的使用才能保证程序稳定运行
 */
public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.work("学Java");
        System.out.println(student);
        State savedStateJava = student.save();

        student.work("打电动");
        System.out.println(student);
        //State savedStateGame = student.save();

        student.restore(savedStateJava);
        System.out.println(student);
        //student.restore(savedStateGame);
        //System.out.println(student);

    }

}
