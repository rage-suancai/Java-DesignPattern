package DasignPattern14;

/**
 * 桥接模式
 * 相信各位都去奶茶店买过奶茶 在购买奶茶的时候 店员首先会问我们 您需要上面类型的奶茶比如我们此时点了一杯啵啵芋圆奶茶
 * 接着店员会直接为我们需要大本 中杯还是小杯 最后还会询问我们需要加上面配料 比如椰果 珍珠等 最后才会给我们制作奶茶
 *
 * 那么现在让你来设计一下这种模式的Java类 该怎么做呢? 首先我们要明确一杯奶茶除了类型之外还分大中小杯 甚至可能还分加上面配料 这个时候 如果我们按照接口实现的写法:
 *                  public interface Tea { // 由具体类型的奶茶实现
 *                      String getType(); // 不同的奶茶返回的类型不同
 *                  }
 *
 *                  public interface Size { // 分大杯小杯中杯
 *                      String getType();
 *                  }
 *
 * 比如现在我们创建一个新的类型:
 *                  public class LargeKissTea implements Tea, Size{ // 大杯美式炭烧咖啡
 *
 *                      @Override
 *                      public String getType() {
 *                          return "美式炭烧咖啡";
 *                      }
 *
 *                      @Override
 *                      public String getSize() {
 *                          return "大杯";
 *                      }
 *
 *                  }
 *
 * 虽然这样设计起来还挺合理的 但是如果现在我们的奶茶品种多起来了 并且每种奶茶都有大中小杯 现在一共有两个为度需要考虑
 * 那么我们岂不是得一个一个去创建这些类? 甚至如果还要考虑配料 那么光创建类记得创建不知道多少个了 显然这种设计不太好 我们得换个方式
 *
 * 这时 就可以使用我们的桥接模式了 现在我们面临的问题是 维度太多 不可能各自类型各种尺寸的奶茶都去创建一个类 那么我们就还是单独对这些接口进行简单的扩展
 * 单独对不同的维度进行控制 但是如何实现呢? 我们不妨将奶茶的类型作为最基本的抽象类 然后对尺寸 配料等属性进行桥接:
 *                  public abstract class AbstractTea {
 *
 *                      protected Size size; // 尺寸作为桥接属性存放在类中
 *
 *                      protected AbstractTea(Size size) { // 在构造时需要知道尺寸属性
 *                          this.size = size;
 *                      }
 *
 *                      public abstract String getType(); // 具体类型依然是由子类决定
 *
 *                  }
 *
 * 不过这个抽象类提供的方法还不全面 仅仅只有Tea的getType方法 我们还需要添加其他维度的方法 所以继续编写一个子类:
 *                  public class RefinedAbstractTea extends AbstractTea {
 *
 *                      protected RefinedAbstractTea(Size size) {
 *                          super(size);
 *                      }
 *
 *                      public String getSize() { // 添加尺寸维度获取方式
 *                          return size.getSize();
 *                      }
 *
 *                  }
 *
 * 现在我们只需要单独为Size创建子类即可:
 *                  public class Large implements Size{
 *
 *                      @Override
 *                      public String getSize() {
 *                          return "大杯";
 *                      }
 *
 *                  }
 *
 * 现在我们如果需要一个大杯的美式炭烧咖啡 只需要:
 *                  public class KissTea extends RefinedAbstractTea { // 创建一个美式炭烧咖啡的子类
 *
 *                      protected KissTea(Size size) { // 在构造时需要指定具体的大小实现
 *                          super(size);
 *                      }
 *
 *                      @Override
 *                      public String getType() {
 *                          return "美式炭烧咖啡"; // 返回奶茶类型
 *                      }
 *
 *                  }
 *
 * 现在我们就将两个维度拆开 可以分别进行配置了:
 *                  KissTea tea = new KissTea(new Large());
 *                  System.out.println(tea.getType());
 *                  System.out.println(tea.getSize());
 *
 * 通过桥接模式 使得抽象和实现可以沿着各自的维度来进行变化 不再是固定的绑定关系
 */
public class Main {

    public static void main(String[] args) {

        /*LargeKissTea tea = new LargeKissTea();
        System.out.println(tea.getType());
        System.out.println(tea.getSize());*/

        KissTea tea = new KissTea(new Large());
        System.out.println(tea.getType());
        System.out.println(tea.getSize());


    }

}
