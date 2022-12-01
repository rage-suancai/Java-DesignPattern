package DasignPattern1;

/**
 * 单一职责原则
 * 单一职责原则(Simple Responsibility Pinciple, SRP) 是最简单的面向对象设计原则 它用于控制类的粒度大小
 *
 *      一个对象应该只要包含单一的职责 并且该职责被完整地封装在应该类中
 *
 * 比如外卖现在有一个People类:
 *                  public class People { // 一个人类
 *
 *                      public void coding(){ // 人类会编程
 *
 *                          System.out.println("int mian() {");
 *                          System.out.println("    printf(\"Holle Wrold\");");
 *                          System.out.println("}");
 *                          System.out.println("啊勒 怎么运行不起? 明明照着老师敲的啊");
 *
 *                      }
 *
 *                      public void work() { // 工厂打螺丝也会
 *
 *                          System.out.println("真开心 能进入到富士康打螺丝");
 *                          System.out.println("哎 怎么工友都提桶跑路了");
 *
 *                      }
 *
 *                      public void ride() { // 送外卖也会
 *
 *                          System.out.println("今天终于通过美团最终面 加入了梦寐以求的大厂");
 *                          System.out.println("感觉面试挺简单的 就是不知道为啥我同学是现场做一道力口接雨水 我是现场问会不会骑车");
 *                          System.out.println("(迫不及待穿上外外卖服)");
 *
 *                      }
 *
 *                  }
 *
 * 外卖可以看到 这个People类可以说是十八般武艺样样精通了 啥都会 但是实际上 外卖每个人最终都是在自己所擅长的领域工作 所谓闻道有先后 术业有专攻
 * 会编程的就应该是程序员 会打螺丝的就应该是工人 会送外卖的应该是骑手 显然这个People太过臃肿(我们需要修改任意一种行为 都需要修改People类)
 * 它拥有不止一个引起它变化的原因) 所以根据单一职责原则 我们下需要进行更明确的划分 同种类型的操作我们一般才放在一起
 *                  public class People {
 *
 *                      class Coder {
 *                          public void coding(){
 *
 *                              System.out.println("int mian() {");
 *                              System.out.println("    printf(\"Holle Wrold\");");
 *                              System.out.println("}");
 *                              System.out.println("啊勒 怎么运行不起? 明明照着老师敲的啊");
 *
 *                          }
 *                      }
 *
 *                      class Worker {
 *                          public void work() {
 *
 *                              System.out.println("真开心 能进入到富士康打螺丝");
 *                              System.out.println("哎 怎么工友都提桶跑路了");
 *
 *                          }
 *                      }
 *
 *                      class Rider {
 *                          public void ride() {
 *
 *                              System.out.println("今天终于通过美团最终面 加入了梦寐以求的大厂");
 *                              System.out.println("感觉面试挺简单的 就是不知道为啥我同学是现场做一道力口接雨水 我是现场问会不会骑车");
 *                              System.out.println("(迫不及待穿上外外卖服)");
 *
 *                          }
 *                      }
 *
 *                  }
 *
 * 我们将类的粒度进行更进一步的划分 这样就很清晰了 包括我们以后在设计Mapper Service Controller等等 根据不同的业务进行划分
 * 都可以采用单一职责原则 以它作为我们实现高内聚低耦合的指导方针 实际上我们的微服务也是参考了单一职责原则 每个微服务只应担负一个职责
 */
public class Main {

    public static void main(String[] args) {

        People.Coder coder = new People().new Coder();
        coder.coding();
        System.out.println();
        People.Worker worker = new People().new Worker();
        worker.work();
        System.out.println();
        People.Rider rider = new People().new Rider();
        rider.ride();

    }

}
