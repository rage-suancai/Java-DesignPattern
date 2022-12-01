package DasignPattern8;

import java.util.function.Supplier;

/**
 * 工厂方法模式
 * 首当其冲的是最简单的一种设计模式——工厂方法模式 我们知道 如果需要创建一个对象 那么最简单的方式就是直接new一个即可
 * 而工厂方法模式代替了传统的直接new的形式 那么为什么要替代传统的new形式呢?
 *
 * 可以想象一下 如果所有的对象我们都通过new的方式去创建 那么当我们的程序中大量使用此对象时 突然有一天这个对象的构造方法或是类发生了修改
 * 那我们岂不是得挨个去进行修改? 根据迪米特法则 我们应该尽可能地少与其他类进行交互 所以我们可以将那些需要频繁出现的对象创建 封装到一个工厂类中
 * 当我们需要对象时 直接调用工厂类中的工厂方法来为我们生成对象 这样 就算类出现了变动 我们也只需要修改工厂中的代码即可 而不是大面积地进行修改
 *
 * 同时 可能某些对象的创建并不只是一个new就可以搞定 可能还需要更多的步骤来准备构造方法需要的参数
 * 所以我们来看看如何使用简单工厂模式来创建对象 既然是工厂 那么我们就来创建点工厂需要生产的东西:
 *                  public abstract class Fruit { // 水果抽象类
 *
 *                      private final String name;
 *
 *                      public Fruit(String name) {
 *                          this.name = name;
 *                      }
 *
 *                      public String toString() {
 *                          return name + "@" + hashCode(); // 打印一下当前水果名称 还有对象的hashCode
 *                      }
 *
 *                  }
 *
 *                  public class Apple extends Fruit { // 苹果 继承自水果
 *
 *                      public Apple() {
 *                          super("苹果");
 *                      }
 *
 *                  }
 *
 *                  public class Orange extends Fruit { // 橘子 也是继承自水果
 *
 *                      public Orange() {
 *                          super("橘子");
 *                      }
 *
 *                  }
 *
 * 正常情况下 我们直接new就可以得到对象了:
 *                  public static void main(String[] args) {
 *
 *                      Apple apple = new Apple();
 *                      System.out.println(apple);
 *                      Orange orange = new Orange();
 *                      System.out.println(orange);
 *
 *                  }
 *
 * 现在我们将对象的创建封装到工厂中:
 *                  public class FruitFactory {
 *                      // 这里就直接来一个静态方法根据指定类型进行创建
 *                      public static Fruit getFruit(String type) {
 *                          switch (type) {
 *                              case "苹果": return new Apple();
 *                              case "橘子": return new Orange();
 *                              default: return null;
 *                          }
 *                      }
 *
 *                  }
 *
 * 现在我们就可以使用此工厂来创建对象了:
 *                  Fruit fruit1 = FruitFactory.getFruit("苹果");
 *                  System.out.println(fruit1);
 *                  Fruit fruit2 = FruitFactory.getFruit("橘子"); // 直接问工厂要 而不是我们自己去创建
 *                  System.out.println(fruit2);
 *
 * 不过这样还是有一些问题 我们前面提到了开闭原则 一个软件实体 比如类 模块和函数应该对扩展开放 对修改关闭 但是如果我们现在需要新增一种水果比如桃子
 * 那么这时我们就得去修改工厂提供的工厂方法了 但是这样是不太符合开闭原则的 因为工厂实际上是针对于调用方提供的 所以我们应该尽可能对修改关闭
 *
 * 所以 我们就利用对扩展开放 对修改关闭的性质 将简单工厂模式改进为工厂方法模式 那现在既然不让改 那么我们就看看如何去使用扩展的形式:
 *                  public abstract class FruitFactory<T extends Fruit> { // 将水果工厂抽象为抽象类 添加泛型T由子类指定水果类
 *                      public abstract T getFruit(); // 不同的水果工厂 通过此方法生产不同的水果
 *                  }
 *
 *                  public class AppleFactory extends FruitFactory<Apple> { // 苹果工厂 直接返回Apple 一步到位
 *
 *                      @Override
 *                      public Apple getFruit() {
 *                          return new Apple();
 *                      }
 *
 *                  }
 *
 * 这样 我们就可以使用不同类型的水果了 并且如果新增了水果类型 直接创建一个新的工厂类就行 不需要修改之前已经编写好的内容
 *                  public static void main(String[] args) {
 *                      test(new AAppleFactory()::getFruit);
 *                  }
 *
 *                  static void test(Supplier<Fruit> supplier) {
 *                      System.out.println(supplier.get() + " 被吃掉了 真好吃")
 *                  }
 * 这样 我们就简单实现了工厂方法模式 通过工厂来屏蔽对象的创建细节 使用者只需要关心如何去使用对象即可
 */
public class Main {

    public static void main(String[] args) {

        /*Apple apple = new Apple();
        System.out.println(apple);
        Orange orange = new Orange();
        System.out.println(orange);*/

        /*Fruit fruit1 = FruitFactory.getFruit("苹果");
        System.out.println(fruit1);
        Fruit fruit2 = FruitFactory.getFruit("橘子");
        System.out.println(fruit2);*/

        test(new AppleFactory()::getFruit);

    }

    static void test(Supplier<Fruit> supplier) {
        System.out.println(supplier.get() + " 被吃掉了 真好吃");
    }

}
