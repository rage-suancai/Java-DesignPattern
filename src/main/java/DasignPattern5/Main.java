package DasignPattern5;

/**
 * 接口隔离原则
 * 接口隔离原则(Interface Segregation Principle, ISP) 实际上是对接口的细化
 *
 *      客户端不应依赖那些它不需要的接口
 *
 * 我们在定义接口的时候 一定要注意控制接口的粒度  比如下面的例子:
 *                  public interface Device {
 *                      String getCpu();
 *                      String getType();
 *                      String getMemory();
 *                  }
 *
 *                  public class Computer implements Device { // 电脑就是一种电子设备 那么我们就实现此接口
 *
 *                      @Override
 *                      public String getCpu() {
 *                          return "i9-12900K";
 *                      }
 *
 *                      @Override
 *                      public String getType() {
 *                          return "电脑";
 *                      }
 *
 *                      @Override
 *                      public String getMemory() {
 *                          return "32G DDR5";
 *                      }
 *
 *                  }
 *
 *                  public class Fan implements Device { // 电风扇也算是一种电子设备
 *
 *                      @Override
 *                      public String getCpu() {
 *                          return null; // 就一个破风扇 还需要CPU?
 *                      }
 *
 *                      @Override
 *                      public String getType() {
 *                          return "风扇";
 *                      }
 *
 *                      @Override
 *                      public String getMemory() {
 *                          return null; // 风扇也不需要内存吧
 *                      }
 *
 *                  }
 *
 * 虽然我们定义了一个Device接口 但是由于此接口的粒度不够细 虽然比较契合电脑这种设备 但是不使合风扇这种设备
 * 因为风扇压根就不需要CPU和内存 所以风扇完全不需要这些方法 这时我们就必须要对其进行更细粒度的划分:
 *                  public interface SmartDevice { // 智能设备才有getCpu和getMemory
 *                      String getCpu();
 *                      String getType();
 *                      String getMemory();
 *                  }
 *
 *                  public interface NormalDevice { // 普通设备只有getType
 *                      String getType();
 *                  }
 *
 *                  public class Computer implements SmartDevice { // 电脑就是一种电子设备 那么我们就继承此接口
 *
 *                      @Override
 *                      public String getCpu() {
 *                          return "i9-12900K";
 *                      }
 *
 *                      @Override
 *                      public String getType() {
 *                          return "电脑";
 *                      }
 *
 *                      @Override
 *                      public String getMemory() {
 *                          return "32G DDR5";
 *                      }
 *
 *                  }
 *
 *                  public class Fan implements NormalDevice { // 风扇也算是一种电子设备
 *
 *                      @Override
 *                      public String getType() {
 *                          return "风扇";
 *                      }
 *
 *                  }
 *
 * 这样 我们就将接口进行了细粒度的划分 不同类型的电子设备就可以根据划分去实现不同的接口了 当然 也不能划分得太小 还是要根据实际情况来进行决定
 */
public class Main {

    public static void main(String[] args) {



    }

}
