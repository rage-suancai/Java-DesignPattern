package DasignPattern15;

/**
 * 组合模式
 * 组合模式实际上就是将多个组件进行组合 让用户可以对它们进行一致性处理 比如我们的文件夹 一个文件夹中可以有很多个子文件夹或是文件
 *
 * 它就像是一个树形结构一样 有分支有叶子 而组合模式则是可以对整树结构上的所有节点进行递归处理
 * 比如我们现在希望将所有文件夹中的文件的名称前面都添加一个前缀 那么就可以使用组合模式
 *
 *                                  --------------------Root--------------------
 *                                  |                    |                     |
 *                                  |                    |                     |
 *                               Branch                 Leaf                 Branch
 *                                  |                                          |
 *                           -------|-------                            -------|-------
 *                           |             |                            |             |
 *                           |             |                            |             |
 *                        Branch          Leaf                        Leaf          Leaf
 *                           |
 *                           |
 *                         Leaf
 *
 * 组合模式的示例如下 这里我们就用文件合文件夹的例子来讲解:
 *                  // 首先创建一个组件抽象 组件可以包含组件 组件有自己的业务方法
 *                  public abstract class Component {
 *
 *                      public abstract void addComponent(Component component); // 添加子组件
 *                      public abstract void removeComponent(Component component); // 删除子组件
 *                      public abstract Component getChild(int index); // 获取子组件
 *                      public abstract void test(); // 执行对应的业务方法 比如修改文件名称
 *
 *                  }
 *
 * 接着我们来编写两种实现类:
 *                  public class Directory extends Component { // 目录可以包含多个文件或目录
 *
 *                      List<Component> child = new ArrayList<>(); // 这里我们使用List来存放目录中的子组件
 *
 *                      @Override
 *                      public void addComponent(Component component) {
 *                          child.add(component);
 *                      }
 *
 *                      @Override
 *                      public void removeComponent(Component component) {
 *                          child.remove(component);
 *                      }
 *
 *                      @Override
 *                      public Component getChild(int index) {
 *                          return child.get(index);
 *                      }
 *
 *                      @Override
 *                      public void test() {
 *                          child.forEach(Component::test); // 将继续调用所有子组件的test方法执行业务
 *                      }
 *
 *                  }
 *
 *                  public class File extends Component { // 文件就相当于是树叶 无法再继续添加子组件了
 *
 *                      @Override
 *                      public void addComponent(Component component) {
 *                          throw new UnsupportedOperationException(); // 不支持这些操作了
 *                      }
 *
 *                      @Override
 *                      public void removeComponent(Component component) {
 *                          throw new UnsupportedOperationException();
 *                      }
 *
 *                      @Override
 *                      public Component getChild(int index) {
 *                          throw new UnsupportedOperationException();
 *                      }
 *
 *                      @Override
 *                      public void test() {
 *                          System.out.println("文件名称修改成功: " + this); // 具体的名称修改操作
 *                      }
 *
 *                  }
 *
 * 最后 我们来测试一下:
 *                  public static void main(String[] args) {
 *
 *                      Directory outer = new Directory(); // 新建一个外层目录
 *                      Directory inner = new Directory(); // 新建一个外层目录
 *                      outer.addComponent(inner);
 *                      outer.addComponent(new File()); // 在内层和外层目录都添加点文件 注意别导错包了
 *                      outer.addComponent(new File());
 *                      outer.addComponent(new File());
 *                      outer.test(); // 开始执行文件名称修改操作
 *
 *                  }
 *
 * 可以看到我们对最外层目录进行操作后 会递归向下处理当前目录和子目录中所有的文件
 */
public class Main {

    public static void main(String[] args) {

        Directory outer = new Directory();
        Directory inner = new Directory();
        outer.addComponent(inner);
        outer.addComponent(new File());
        outer.addComponent(new File());
        outer.addComponent(new File());
        outer.test();

    }

}
