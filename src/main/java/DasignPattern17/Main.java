package DasignPattern17;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理模式
 * 代理模式和装者模式很想 初学者很容易搞混 所以这里我们得紧接着来讲解一下 首先请记住 当无法直接访问某对象或访问某个对象存在困难时 我们就可以通过一个代理对象来间接访问
 *
 * 实际上代理我们在我们生活中处处都存在 比如手机厂商要去销售手机 但是手机厂商本身没有没有渠道可以大规模地进行售卖 很难与这些消费者进行对接
 * 这时就得交给代理商去进行出售 比如Apple在中国的直营店很少 但是在中国的授权经销商却很多 手机厂商通过交给旗下代理商的形式来进行更大规模的出售
 * 比如我们经常要访问Github 但是直接连接会发现很难连的上 这时我们加了一个代理就可以轻松访问 也是在体现代理的作用
 *
 * 同时 代理类需要保证客户端使用的透明性 也就是说操作起来需要与原本的真实对象相同 比如我们访问Github只需要输入网址即可访问
 * 而添加代理之后 也是使用同样的方式去访问Github 所以操作起来是一样的 包括Spring框架其实也是依靠代理模式去实现的AOP记录日志等
 *
 * 比如现在有一个日志类 但是我们现在需要通过代理来使用它:
 *                  public abstract class Subject {
 *                      public abstract void test();
 *                  }
 *
 *                  public class SubjectImpl extends Subject { // 此类无法直接使用 需要我们进行代理
 *
 *                      @Override
 *                      public void test() {
 *                          System.out.println("我是测试方法");
 *                      }
 *
 *                  }
 *
 * 现在我们为其建立一个代理类:
 *                  public class Proxy extends Subject { // 为了保证和Subject操作方式一样 保证透明性 也得继承
 *
 *                      Subject target; // 被代理的对象(甚至可以多重代理)
 *
 *                      public Proxy(Subject subject) {
 *                          this.target = subject;
 *                      }
 *
 *                      @Override
 *                      public void test() { // 由代理去执行被代理对象的方法 并且我们还可以在前后添油加醋
 *                          System.out.println("代理前绕方法");
 *                          target.test();
 *                          System.out.println("代理后绕方法");
 *                      }
 *
 *                  }
 *
 * 乍一看 这不跟之前的装饰模式一模一样吗?
 *
 * 对装饰器模式来说 装饰者和被装饰都是实现同一个接口/抽象类 对代理模式来说 代理类和被代理的类都实现同一个接口/抽象类 在结构上确实没有啥区别
 * 但是他们的作用不同 装饰器模式强调的是增强自身 在被装饰之后你能够在被增强的类上使用增强后的功能 增强后你还是你只不过被强化了而已
 * 代理模式强调要让别人帮你去做事情 以及添加一些本身与你业务没有太多关系的事情(记录日志 设置缓存等)重点在与别人帮你做
 *
 * 装饰模式和代理模式的不同之处在于思想
 *
 * 当然实现代理模式除了我们上面所说的这种方式之外 我们还可以使用JDK为我们提供的动态代理机制 我们不再需要手动编写继承关系创建代理类 它能够在运行时通过反射机制为我们自动生生成代理类:
 *                  public interface Proxy2 { // JDK提供的动态代理只支持接口
 *                      void test1();
 *                  }
 *
 *                  public class SubjectImpl2 implements Subject2 {
 *
 *                      @Override
 *                      public void test() {
 *                          System.out.println("我是测试方法");
 *                      }
 *
 *                  }
 *
 * 接着我们需要创建一个动态代理的处理逻辑:
 *                  public class Proxy2 implements InvocationHandler { // 代理类 需要实现InvocationHandler接口
 *
 *                      private final Object object; // 这里需要保存一下被代理的对象 下面需要用到
 *
 *                      public Proxy2(Object object) {
 *                          this.object = object;
 *                      }
 *
 *                      @Override // 此方法就是调用代理对象的对应方法时会进入 这里我们就需要编写如何进行代理了
 *                      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
 *                          // method就是调用的代理对象的哪一个方法 args是实参数组
 *                          System.out.println("代理的对象: " + proxy.getClass()); // proxy就是生成的代理对象了 我们看看是什么类型的
 *                          Object res = method.invoke(object, args); // 在代理中调用代理对象原本的方法 因为你是代理 还是得执行一下别人的业务 当然也可以不执行 但是这样就失去代理的意义了 注意要用到上面的object
 *                          System.out.println("方法调用完成, 返回值为: " + res); // 看看返回值是什么
 *                          return res; // 返回返回值
 *
 *                      }
 *
 *                  }
 *
 * 最后我们来来看看如何创建一个代理类:
 *                  public static void main(String[] args) {
 *
 *                      SubjectImpl2 subject2 = new SubjectImpl2(); // 被代理的大冤种
 *                      InvocationHandler handler = new Proxy2(subject2);
 *                      Subject2 proxy2 = (Subject2) Proxy.newProxyInstance(
 *                              subject2.getClass().getClassLoader(), // 需要传入被代理的类的类加载器
 *                              subject2.getClass().getInterfaces(), // 需要传入被代理的类的接口列表
 *                              handler); // 最后传入我们实现的代理处理逻辑实现类
 *                      proxy2.test(); // 比如现在我们调用的代理类的test方法 那么就会进入到我们上面Proxy2中invoke方法 走我们的代理逻辑
 *
 *                  }
 *
 * 运行一次 可以看到调用的代理类的方法 最终会走到我们的invoke方法中进行:
 *                  代理的对象: class jdk.proxy1.$Proxy0
 *                  我是测试方法
 *                  方法调用完成, 返回值为: null
 *
 * 根据接口 代理对象是class jdk.proxy1.$Proxy0类(看名字就知道不对劲) 这个类是动态生成的 我们也找不到具体的源代码
 *
 * 不过JDK提供的动态代理只能使用接口 如果换成我们一开始的抽象类 就没办法了 这时我们可以使用一些第三方框架来实现更多方式的动态代理 比如Spring都在使用CGlib框架 Maven依赖如下:
 *                  <dependency>
 *                      <groupId>cglib</groupId>
 *                      <artifactId>cglib</artifactId>
 *                      <version>3.1</version>
 *                  </dependency>
 *
 * 由于CGlib底层使用ASM框架(JVM篇视频教程有介绍) 进行字节码编辑 所以能够实现不仅仅局限于对接口的代理:
 *                  public class Proxy3 implements MethodInterceptor { // 首先还是编写我们的代理逻辑
 *
 *                      private final Object target; // 这些和之前JDK动态代理写法是一样的
 *
 *                      public Proxy3(Object target) {
 *                          this.target = target;
 *                      }
 *
 *                      @Override // 我们也是需要在这里去编写我们的代理逻辑
 *                      public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
 *
 *                          System.out.println("现在是由CGlib进行代理操作" + o.getClass());
 *                          return method.invoke(target, objects); // 也是直接调用代理对象的方法即可
 *
 *                      }
 *
 *                  }
 *
 * 接着我们来创建一下代理类:
 *                  SubjectImpl2 subject2 = new SubjectImpl2();
 *                  Enhancer enhancer = new Enhancer(); // 增强器 用一会需要依靠增强器来为我们生成动态代理对象
 *                  enhancer.setSuperclass(SubjectImpl2.class); // 直接选择我们需要代理的类型 直接不需要接口或是抽象类 SuperClass作为代理类的父类存在 这样我们就可以按照指定类型的方式去操作代理类了
 *                  enhancer.setCallback(new Proxy3(subject2)); // 设定我们刚刚编写好的代理逻辑
 *                  SubjectImpl2 proxy = (SubjectImpl2) enhancer.create(); // 直接创建代理类
 *                  proxy.test(); // 调用代理类的test方法
 *
 * 可以看到 效果其实差不多的:
 *                  现在是由CGlib进行代理操作class DasignPattern17.SubjectImpl2$$EnhancerByCGLIB$$5321aa58
 *                  我是测试方法
 *
 * 可以看到代理类是包名.SubjectImpl2$$EnhancerByCGLIB$$5321aa58 也是动态生成的一个类 所以我们无法去查看源代码 不过此类是继承自我们指定的类型的
 */
public class Main {

    public static void main(String[] args) {

        /*SubjectImpl2 subject2 = new SubjectImpl2();
        InvocationHandler handler = new Proxy2(subject2);
        Subject2 proxy2 = (Subject2) Proxy.newProxyInstance(
                subject2.getClass().getClassLoader(),
                subject2.getClass().getInterfaces(),
                handler);
        proxy2.test();*/

        SubjectImpl2 subject2 = new SubjectImpl2();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SubjectImpl2.class);
        enhancer.setCallback(new Proxy3(subject2));
        SubjectImpl2 proxy = (SubjectImpl2) enhancer.create();
        proxy.test();

    }

}
