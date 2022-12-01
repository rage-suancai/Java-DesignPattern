package DasignPattern24;

import java.util.Arrays;
import java.util.List;

/**
 * 迭代器模式
 * 迭代器我们在JavaSE篇就已经讲解过了 迭代器可以说是我们学习Java语言的基础
 * 没有迭代器集合类的遍历就成了问题 正是因为有迭代器的存在 我们才能更加优雅的使用foreach语法
 *
 * 回顾我们之前使用迭代器的场景:
 *                  List<String> list = Arrays.asList("AAA", "BBB", "CCC");
 *                  for (String s : list) { // 使用foreach语法糖进行迭代 依次获取每一个元素
 *                      System.out.println(s); // 打印一下
 *                  }
 *
 * 编译之后的代码如下:
 *                  public class Main {
 *                      public Main() {
 *                      }
 *
 *                      public static void main(String[] args) {
 *                          List<String> list = Arrays.asList("AAA", "BBB", "CCC");
 *                          Iterator var2 = list.iterator(); // 实际上这里本质是通过List生成的迭代器来遍历我们每个元素的
 *
 *                          while(var2.hasNext()) { // 判断是还有元素可以迭代 没有就false
 *                              String s = (String)var2.next(); // 通过next方法得到下一个元素 每调用一次 迭代器会向后移动一位
 *                              System.out.println(s); // 打印一下
 *                          }
 *
 *                      }
 *                  }
 *
 * 可以看到 当我们使用迭代器对List进行遍历时 实际上就像一个指向列表头部的指针 我们通过不断向后移动指针来依次获取所指向的元素:
 *
 *                              [AAA] [BBB] [CCC] [DDD] [EEE] [...] [] [] [] []
 *                                |
 *                              next()方法会返回当前指针指向的元素 并将指针移一位
 *
 *                              [AAA] [BBB] [CCC] [DDD] [EEE] [...] [] [] [] []
 *                                      |
 *                                  调用后的情况
 *
 * 这里 我们依照JDK提供的迭代器接口(JDK已经为我们定义好了一个迭代器的具体相关操作)也来设计一个迭代器
 *                  public class ArrayCollection<T> { // 首先设计一个简单的数组集合 一会我们就迭代此集合的元素
 *
 *                      private final T[] array; // 底层使用一个数组来存放数据
 *
 *                      private ArrayCollection(T[] array) { // private掉 自己用
 *                          this.array = array;
 *                      }
 *
 *                      public static <T> ArrayCollection<T> of(T[] array) { // 开个静态方法直接把数组转换成ArrayCollection 其实和直接new一样 但是这样写好看一点
 *                          return new ArrayCollection<>(array);
 *                      }
 *
 *                  }
 *
 * 现在我们就可以将数据存放在此集合中了:
 *                  String[] arr = new String[] {"AAA", "BBB", "CCC", "DDD"};
 *                  ArrayCollection<Object> collection = ArrayCollection.of(arr);
 *
 * 接着我们就可以来实现迭代器接口了:
 *                  public class ArrayCollection<T> implements Iterable<T> { // 实现Iterable接口表示此类型是支持迭代的
 *
 *                      ...
 *
 *                      @Override
 *                      public Iterator<T> iterator() { // 需要实现iterator方法 此方法会返回一个迭代器 用于迭代我们集合中的元素
 *                          return new ArrayIterator();
 *                      }
 *
 *                      public class ArrayIterator implements Iterator<T> { // 这里实现了一个(注意别用静态)需要使用对象中存放的数组
 *
 *                          private int cur = 0; // 这里我们通过一个指针表示当前的迭代位置
 *
 *                          @Override
 *                          public boolean hasNext() { // 判断是否还有下一个元素
 *                              return cur < array.length; // 如果指针大于或等于数组最大长度 就不能再继续了
 *                          }
 *
 *                          @Override
 *                          public T next() { // 返回当前指针位置的元素并行向后移动一位
 *                              return array[cur++]; // 正常返回对应位置的元素 并将指针自增
 *                          }
 *
 *                      }
 *
 *                  }
 *
 * 接着 我们就可以对我们自己编写的一个简单集合类进行迭代了:
 *                  String[] arr = new String[] {"AAA", "BBB", "CCC", "DDD"};
 *                  ArrayCollection<String> collection = ArrayCollection.of(arr);
 *                  for (String s : collection) { // 可以直接使用foreach语法糖 当然最后还是会变成迭代器调用
 *                      System.out.println(s);
 *                  }
 *
 * 最后编译出来的样子:
 *                  public class Main {
 *                      public Main() {
 *                      }
 *
 *                      public static void main(String[] args) {
 *                          String[] arr = new String[]{"AAA", "BBB", "CCC", "DDD"};
 *                          ArrayCollection<String> collection = ArrayCollection.of(arr);
 *                          Iterator var3 = collection.iterator(); // 首先获取迭代器 实际上就是调用我们实现的iterator方法
 *
 *                          while(var3.hasNext()) {
 *                              String s = (String)var3.next(); // 直接使用next()方法不断向下获取
 *                              System.out.println(s);
 *                          }
 *
 *                      }
 *                  }
 *
 * 这样我们就实现了一个迭代器来遍历我们的元素
 */
public class Main {

    public static void main(String[] args) {

        /*List<String> list = Arrays.asList("AAA", "BBB", "CCC");
        for (String s : list) System.out.println(s);*/

        String[] arr = new String[] {"AAA", "BBB", "CCC", "DDD"};
        ArrayCollection<String> collection = ArrayCollection.of(arr);
        for (String s : collection) {
            System.out.println(s);
        }

    }

}

