package DasignPattern13;

/**
 * 类/对象 适配器模式
 * 在生活中 我们经常遇到这样的一个问题: 笔记本太轻薄了 以至于没有RJ45网口和USB A口(比如Macbook为了轻薄甚至全是type-c形式的雷电口) 但是现在我们因为工作需要
 * 又得使用这些接口来连接线缆 这时我们想到的第一个解决方案 就是去买一个转接口(扩展坞) 扩展坞可以将type-c口转换为其他类型的接口供我们使用 实际上这就是一种适配模式
 *
 *                                                                           进行接口适配
 *                            马克布笔记本 -----> [只有四个type-c接口] -----> [扩展坞type转HDMI] -----> [只有一个HDMI接口] -----> 5K显示器
 *
 * 由于我们的电脑没有这些接口 但是提供了type-c类的接口 虽然接口类型不一样 但是同样可以做其他接口能够做的事情 比如USB文件传输 有线网络连接等
 * 所以 这个时候 我们只需要添加一个中间人来帮我们转换一下接口形态即可 包括我们常用的充电头 为什么叫电源适配器呢? 我们知道传统的供电是220V交流电
 * 但是我们的手机可能只需要5V的电压进行充电 虽然现在有电 但是不能直接充 我们也不可能让电力公司专门为我们提供了一个5V的直流电使用 这时电源适配器就开始
 * 发挥作用了 比如苹果的祖传5V1A充电头 实际上就是将220V交流电转换为5V的直流电进行传输 这样就相当于再220V交流电和我们的手机之前 做了一个适配器的角色
 *
 * 在我们的Java程序中 也会经常遇到这样的问题 比如:
 *                  public class TestSupplier { // 手机供应商
 *
 *                      public String doSupply() {
 *                          return "iPhone 14 Pro";
 *                      }
 *
 *                  }
 *
 *                  public class Main {
 *
 *                      public static void main(String[] args) {
 *
 *                          TestSupplier supplier = new TestSupplier();
 *                          test( ? ); // 我们没有Target类型的手机供应商 只有其他的 那这里该填个啥
 *
 *                      }
 *
 *                      static void test(Target target) { // 现在我们需要调用test方法 但是test方法需要Target类型的手机供应商
 *                          System.out.println("成功得到: " + target.supply());
 *                      }
 *
 *                  }
 *
 *                  public interface Target { // 现在的手机供应商 并不是test方法所需要的那种类型
 *                      String supply();
 *                  }
 *
 * 这个时候 我们就可以使用适配器模式了 适配器模式分为类适配器和对象适配器 我们首先来看看如何使用类适配器解决这种问题 我们直接创建一个适配器类:
 *                  public class TestAdapter extends TestSupplier implements Target{
 *                      // 让我们的适配器继承TestSupplier并且实现Target接口
 *                      @Override
 *                      public String supply() { // 接着实现supply方法 直接使用TestSupplier提供的实现
 *                          return super.doSupply();
 *                      }
 *
 *                  }
 *
 * 这样 我们就得到了一个Target类型的实现类 并且同时采用的是TestSupplier提供的实现
 *                  public static void main(String[] args) {
 *
 *                      TestAdapter adapter = new TestAdapter();
 *                      test(adapter);
 *
 *                  }
 *
 *                  static void test(Target target) {
 *                      System.out.println("成功得到: " + target.supply());
 *                  }
 *
 * 不过 这种实现方式需要占用一个继承坑位 如果此时Target不是接口而是抽象类的话 由于Java不支持多继承 那么就无法实现了
 * 同时根据合成复用原则 我们应该更多的通过合成的方式去实现功能 所以我们来看看第二种 也是用的比较多的一种模式 对象适配器:
 *                  public class TestAdapter implements Target{ // 现在不再继承TestSupplier 仅实现Target
 *
 *                      TestSupplier supplier;
 *
 *                      public TestAdapter(TestSupplier supplier) {
 *                          this.supplier = supplier;
 *                      }
 *
 *                      @Override
 *                      public String supply() {
 *                          return supplier.doSupply();
 *                      }
 *
 *                  }
 *
 * 现在 我们就将对象以组合的形式存放在TestAdapter中 依然是通过存放的对象调用具体实现
 */
public class Main {

    public static void main(String[] args) {

        TestSupplier supplier = new TestSupplier();
        TestAdapter adapter = new TestAdapter(supplier);
        test(adapter);

    }

    static void test(Target target) {
        System.out.println("成功得到: " + target.supply());
    }

}
