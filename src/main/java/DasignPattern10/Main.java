package DasignPattern10;

/**
 * 建造者模式
 * 建造者模式也是非常常见的一种设计模式 我们经常看到有很多的框架为我们提供了形如XXXBuilder的类型 我们一般也是使用这些类型来创建我们需要的对象
 *
 * 比如 我们在JavaSE中就学习过的StringBuilder类:
 *                  StringBuilder builder = new StringBuilder(); // 创建一个StringBuilder来逐步构建一个字符
 *                  builder.append(666); // 拼接一个数字
 *                  builder.append("老铁"); // 拼接一个字符串
 *                  builder.insert(2, '?'); // 在第三个位置插入一个字符
 *                  System.out.println(builder.toString()); // 差不多成形了 最后转换为字符串
 *
 * 实际上我们是通过建造者来不断配置参数或是内容 当我们配置完所有内容后 最后一个再进行对象的构建
 *
 * 相比直接去new一个新的对象 建造者模式的重心更加关注在如何完成每一步的配置 同时如果一个类的构造方法参数过多 我们通过建造者模式来创建这个对象 会更加优雅
 *
 * 比如我们现在有一个学生类:
 *                  public class Student {
 *
 *                      int id;
 *                      int age;
 *                      int grade;
 *                      String name;
 *                      String college;
 *                      String profession;
 *                      List<String> awards;
 *
 *                      public Student(int id, int age, int grade, String name, String college, String profession, List<String> awards) {
 *                          this.id = id;
 *                          this.age = age;
 *                          this.grade = grade;
 *                          this.name = name;
 *                          this.college = college;
 *                          this.profession = profession;
 *                          this.awards = awards;
 *                      }
 *
 *                  }
 *
 * 可以看到这个学生类的属性是非常多的 所以构造方法不是一般的长 如果我们现在直接通过new的方式去创建:
 *                  Student student = new Student(1, 18, 3, "小明", "计算机学院", "计算机科学与技术", Arrays.asList("ICPC_ACM 区域赛 金牌", "LPL 2022 春季赛 冠军"));
 *
 * 可以看到 我们光是填参数就麻烦 我们还得一个一个对应着去填 一不小心可能就把参数填到错误的位置了
 *
 * 所以我们现在可以使用建造者模式来进行对象的创建:
 *                  public class Student {
 *
 *                      ...
 *
 *                      // 一律使用建造者来来创建 不对外直接开放
 *                      private Student(int id, int age, int grade, String name, String college, String profession, List<String> awards) {
 *                          ...
 *                      }
 *
 *                      public static StudentBuilder builder() { // 通过builder方法直接获取建造者
 *                          return new StudentBuilder();
 *                      }
 *
 *                      public static class StudentBuilder { // 这里就直接创建一个内部类
 *                          // Builder也需要将所有的参数都进行暂时保存 所以Student怎么定义的这里就怎么定义
 *                          int id;
 *                          int age;
 *                          int grade;
 *                          String name;
 *                          String college;
 *                          String profession;
 *                          List<String> awards;
 *
 *                          public StudentBuilder id(int id) { // 直接调用建造者对应的方法 为对应的属性赋值
 *                              this.id = id;
 *                              return this; // 为了支持链式调用 这里直接返回建造者本身 下同
 *                          }
 *                          public StudentBuilder age(int age) {
 *                              this.age = age;
 *                              return this;
 *                          }
 *
 *                          ...
 *
 *                          public StudentBuilder awards(String... awards) {
 *                              this.awards = Arrays.asList(awards);
 *                              return this;
 *                          }
 *
 *                          public Student build() { // 最后我们只需要调用建造者提供的build方法即可根据我们的配置返回一个对象
 *                              return new Student(id, age, grade, name, college, profession, awards);
 *                          }
 *
 *                      }
 *
 *                  }
 *
 *                  public static void main(String[] args) {
 *                      Student student = Student.builder() // 获取建造者
 *                              .id(1) // 逐步配置各个参数
 *                              .age(18)
 *                              .grade(3)
 *                              .name("小明")
 *                              .awards("ICPC_ACM 区域赛 金牌", "LPL 2022 春季赛 冠军")
 *                              .build(); // 最后直接建造我们想要的对象
 *                  }
 *
 * 我们就可以让这些参数对号入座了 并且也比之前的方式优雅许多
 */
public class Main {

    public static void main(String[] args) {

        /*StringBuilder builder = new StringBuilder();
        builder.append(666);
        builder.append("老铁");
        builder.insert(2, '?');
        System.out.println(builder.toString());*/

        //Student student = new Student(1, 18, 3, "小明", "计算机学院", "计算机科学与技术", Arrays.asList("ICPC_ACM 区域赛 金牌", "LPL 2022 春季赛 冠军"));

        Student student = Student.builder()
                .id(1)
                .age(18)
                .grade(3)
                .name("小明")
                .awards("ICPC_ACM 区域赛 金牌", "LPL 2022 春季赛 冠军")
                .build();
        System.out.println(student.awards);

    }

}
