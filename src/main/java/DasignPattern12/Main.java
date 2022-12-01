package DasignPattern12;

import DasignPattern11.Singleton2;

/**
 * 原型模式
 * 原型模式实际上与对象的拷贝息息相关 原型模式使用原型实例指定待创建的类型 并且通过复制这个原型来创建新的对象
 * 也就是说原型对象作为模板 通过克隆操作 来产生更多的对象 就像细胞的复制一样
 *
 * 开始之前 完美先介绍一下对象的深拷贝和浅拷贝 首先我们来看浅拷贝:
 *      > 浅拷贝: 对于类中基本数据类型 会直接复制值拷贝对象 对于引用类型 只会复制对象的地址 而实际上指向的还是原来的那个对象 拷贝个寂寞
 *                          public static void main(String[] args) {
 *
 *                              int a = 10, b = a; // 基本类型浅拷贝
 *                              System.out.println(a == b);
 *
 *                              Object o = new Object();
 *                              Object k  = o; // 引用类型浅拷贝 拷贝的仅仅是对上面对象的引用
 *                              System.out.println(o == k);
 *
 *                          }
 *
 *      > 深拷贝: 无论是基本类型还是引用类型 深拷贝会将引用类型的所有内容 全部拷贝为一个新的对象 包括对象内部的所有成员变量 也会进行拷贝
 *
 * 在Java中 我们就可以使用Cloneable接口提供的拷贝机制 来实现原型模式:
 *                  public class Student implements Cloneable { // 注意需要实现Cloneable接口
 *
 *                      @Override
 *                      protected Object clone() throws CloneNotSupportedException { // 提升clone方法的访问权限
 *                          return super.clone();
 *                      }
 *
 *                  }
 *
 * 接着我们来看看克隆的对象是不是原来的对象:
 *                  static void test2() {
 *
 *                      try {
 *                          Student student1 = new Student();
 *                          Student student2 = (Student) student1.clone();
 *                          System.out.println(student1);
 *                          System.out.println(student2);
 *                      } catch (CloneNotSupportedException e) {
 *                          e.printStackTrace();
 *                      }
 *
 *                  }
 *
 * 可以看到 通过clone()方法克隆的对象并不是原来的对象 我们来看看如果对象内部有属性会不会一起进行克隆:
 *                  public class Student implements Cloneable {
 *
 *                      String name;
 *
 *                      public Student(String name) {
 *                          this.name = name;
 *                      }
 *
 *                      public String getName() {
 *                          return name;
 *                      }
 *
 *                      @Override
 *                      protected Object clone() throws CloneNotSupportedException {
 *                          return super.clone();
 *                      }
 *
 *                  }
 *
 * 可以看到 虽然Student对象成功拷贝 但是其他内层对象并没有进行拷贝 依然只是对象引用的复制 所以Java为我们提供的clone方法只会进行浅拷贝 那么如何才能实现深拷贝呢?
 *                  @Override
 *                  protected Object clone() throws CloneNotSupportedException { // 这里我们改进一下 针对成员变量也进行拷贝
 *
 *                      Student student = (Student) super.clone();
 *                      student.name = new String(name);
 *                      return student; //  成员拷贝完成后 再返回
 *
 *                  }
 *
 * 这样 我们就实现了深拷贝
 */
public class Main {

    static void test1() {

        int a = 10, b = a;
        System.out.println(a == b);

        Object o = new Object();
        Object k = o;
        System.out.println(o == k);

    }

    static void test2() {

        /*try {
            Student student1 = new Student();
            Student student2 = (Student) student1.clone();
            System.out.println(student1);
            System.out.println(student2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/

        try {
            Student student1 = new Student("小明");
            Student student2 = (Student) student1.clone();
            System.out.println(student1.getName() == student2.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
