package DasignPattern4;

/**
 * 依赖倒转原则
 * 依赖倒转原则(Dependence Inversion Principle) 也是我们一直在使用的 最明显的就是我们的Spring框架了
 *
 *      高层模块不应依赖与底层模块 它们都应该依赖抽象 抽象不应依赖与细节 细节应该依赖于抽象
 *
 * 还记得我们在我们之前的学习中为什么要一直使用接口来进行功能定义 然后再去实现吗? 我们回顾一下在使用Spring框架之前的情况:
 *                  public class Main {
 *
 *                      public static void main(String[] args) {
 *
 *                          UserController controller = new UserController();
 *                          // 该怎么用就怎么用
 *
 *                      }
 *
 *                      static class UserMapper {
 *                          // CRUD
 *                      }
 *
 *                      static class UserService {
 *                          UserMapper  mapper = new UserMapper();
 *                          // 业务代码...
 *                      }
 *
 *                      static class UserController {
 *                          UserService service = new UserService();
 *                          // 业务代码...
 *                      }
 *
 *                  }
 *
 * 但是突然有一天 公司业务需求变化 现在用户相关的业务操作需要使用新的实现:
 *                  public class Main {
 *
 *                      public static void main(String[] args) {
 *
 *                          UserController controller = new UserController();
 *
 *                      }
 *
 *                      static class UserMapper {
 *                          // CRUD
 *                      }
 *
 *                      static class UserServiceNew { // 由于UserServiceNew发生变化 会直接影响倒其他高层模块
 *                          UserMapper  mapper = new UserMapper();
 *                          // 业务代码...
 *                      }
 *
 *                      static class UserController { // 艹 干嘛改底层啊 我这又得重写了
 *                          UserService service = new UserService(); // 哦豁 原来的不能用了
 *                          UserServiceNew serviceNew = new UserServiceNew(); // 只能修改成新的了
 *                          // 业务代码
 *                      }
 *
 *                  }
 *
 * 我们发现 我们的各个模块之间实际上是具有强关联的 一个模块是直接指定依赖于另一个模块 虽然这样结构清晰 但是底层模块的变动
 * 会直接影响倒其他依赖于它的高层模块 如果我们的项目变的得很庞大 那么这样的修改将是一场灾难
 *
 * 而有了Spring框架之后 我们的开发模式就发生了变化:
 *                  public class Main {
 *
 *                      public static void main(String[] args) {
 *
 *                          UserController controller = new UserController();
 *
 *                      }
 *
 *                      interface UserMapper {
 *                          // 接口中只做CRUD方法定义
 *                      }
 *                      interface UserService {
 *                          // 业务代码定义...
 *                      }
 *
 *                      static class UserMapperImpl implements UserMapper {
 *
 *                      }
 *
 *                      static class UserServiceImpl implements UserService {
 *                          @Resource // 现在由Spring来为我们选择一个指定的实现类 然后注入 而不是由我们在类中硬编码进行指定
 *                          UserMapper mapper;
 *                          // 业务代码具体实现
 *                      }
 *
 *                      static class UserController {
 *                          @Resource
 *                          UserService service; // 直接使用接口 就算你改实现 我们也不需要再修改代码了
 *                          // 业务代码...
 *                      }
 *
 *                  }
 *
 * 可以看到 通过使用接口 我们就可以将原有的强大结构弱化 我们只需要找到接口中定义了什么方法然后去使用即可
 * 而具体的操作由接口的实现来完成 并由Spring来为我们注入 而不是我们通过硬编码的方式去指定
 */
public class Main {

    public static void main(String[] args) {

        //UserController controller = new UserController();

    }

    /*interface UserMapper {

    }
    interface UserService {

    }

    static class UserMapperImpl implements UserMapper {

    }

    static class UserServiceImpl implements UserService {
        @Resource
        UserMapper mapper;
    }

    static class UserController {
        @Resource
        UserService service;
    }*/

}
