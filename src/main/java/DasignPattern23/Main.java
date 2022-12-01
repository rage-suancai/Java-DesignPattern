package DasignPattern23;

/**
 * 命令模式
 * 大家有没有发现现在的家电都在趋向于智能化 通过一个中央控制器 我们就可以对家里的很多电器进行控制 比如国内做的比较好的小米智能家居系列
 * 还有Apple的HomeKit等 我们只需要在一个终端上进行操作 就可以随便控制家里的电器
 *
 * 比如现在我们有很多的类 彩电 冰箱 空调 洗衣机 热水器等 既然现在我们要通过一个遥控器去控制他们
 * 那么我们就需要将控制的这些电器的指令都给设计好才行 并且还不能有太强的关联性
 *
 * 所有的电器肯定需要通过蓝牙或是红外线接收遥控器发送的请求 所以所有的电器都是接收者:
 *                  public interface Receiver {
 *                      void action(); // 具体行为 这里就写一个算了
 *                  }
 *
 * 接着我们要控制这些电器 那么肯定需要一个指令才能控制:
 *                  public abstract class Command { // 指令抽象 不同的电器有指令
 *
 *                      private final Receiver receiver;
 *
 *                      protected Command(Receiver receiver) { // 指定此命令对应的电器(接受者)
 *                          this.receiver = receiver;
 *                      }
 *
 *                      public void execute() {
 *                          receiver.action(); // 执行命令 实际上就是让接收者开始干活
 *                      }
 *
 *                  }
 *
 * 最后我们来安排一个遥控器:
 *                  public class Controller { // 遥控器只需要把我们的指令发出去就行了
 *
 *                      public static void call(Command Command) {
 *                          Command.execute();
 *                      }
 *
 *                  }
 *
 * 比如现在我们创建一个空调 那么它就是作为我们命令的接收者:
 *                  public class AirConditioner implements Receiver{
 *
 *                      @Override
 *                      public void action() {
 *                          System.out.println("空调已开启 呼呼呼~");
 *                      }
 *
 *                  }
 *
 * 现在我们创建一个开启空调的命令:
 *                  public class OpenCommand extends Command {
 *
 *                      public OpenCommand(AirConditioner airConditioner) {
 *                          super(airConditioner);
 *                      }
 *
 *                  }
 *
 * 最后我们需要通过遥控器发送出去就可以了:
 *                  public static void main(String[] args) {
 *
 *                      AirConditioner airConditioner = new AirConditioner(); // 先创建一个空调
 *                      Controller.call(new OpenCommand(airConditioner)); // 直接通过遥控器来发送空调开启命令
 *
 *                  }
 *
 * 通过这种方式 遥控器这个角色并不需要知道会执行什么 只需要发送命令即可 遥控器和电器的关联性就不再那么强了
 */
public class Main {

    public static void main(String[] args) {

        AirConditioner airConditioner = new AirConditioner();
        Controller.callAC(new OpenCommand(airConditioner));
        Controller.CallOFF(new OpenCommand(airConditioner));

    }

}
