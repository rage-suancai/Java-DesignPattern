package DasignPattern16;

/**
 * 装饰模式
 * 装饰模式就像其名字一样 为了对现有的类进行装饰 比如一张相片就一张纸 如果直接贴在墙上 总感觉少了点什么 但是我们给其添加一个好看的相框 就会变得非常对味
 * 装饰模式的核心就在于不改变一个对象本身功能的基础上 给对象添加额外的行为 并且它通过组合的形式完成的 而不是传统的继承关系
 *
 * 比如我们现在有一个普通的功能类:
 *                  public abstract class Base { // 顶层抽象类 定义了一个test方法执行业务
 *                      public abstract void test();
 *                  }
 *
 *                  public class BaseImpl extends Base {
 *
 *                      @Override
 *                      public void test() {
 *                          System.out.println("我是业务方法"); // 具体的业务方法
 *                      }
 *
 *                  }
 *
 * 不过现在的实现类太单调了 我们来添加一点装饰上去:
 *                  public class Decorator extends Base { // 装饰模式需要将装饰目标组合到类中
 *
 *                      protected Base base;
 *
 *                      public Decorator(Base base) {
 *                          this.base = base;
 *                      }
 *
 *                      @Override
 *                      public void test() {
 *                          base.test(); // 这里暂时还是使用目标的原本方法实现
 *                      }
 *
 *                  }
 *
 *                  public class DecoratorImpl extends Decorator { // 装饰实现
 *
 *                      public DecoratorImpl(Base base) {
 *                          super(base);
 *                      }
 *
 *                      @Override
 *                      public void test() { // 对原本的方法进行装饰 我们可以在前后都去添加额外操作
 *
 *                          System.out.println("装饰方法: 我是操作前逻辑");
 *                          super.test();
 *                          System.out.println("装饰方法: 我是操作后逻辑");
 *
 *                      }
 *
 *                  }
 *
 * 这样 我们就通过装饰模式对类的功能进行了扩展:
 *                  public static void main(String[] args) {
 *
 *                      Base base = new BaseImpl();
 *                      Decorator decorator = new DecoratorImpl(base); // 将Base实现装饰一下
 *                      Decorator outer = new DecoratorImpl(decorator); // 装饰者还可以嵌套
 *
 *                      decorator.test();
 *                      outer.test();
 *
 *                  }
 *
 * 这样我们就实现了装饰模式
 */
public class Main {

    public static void main(String[] args) {

        Base base = new BaseImpl();
        Decorator decorator = new DecoratorImpl(base);
        Decorator outer = new DecoratorImpl(decorator);

        decorator.test();
        outer.test();

    }

}
