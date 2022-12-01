package DasignPattern18;

/**
 * 外观模式
 * 你是否经历过类似的情况: 今年计算机学院的奖学金评定工作开始了 由于你去年一不小心拿了个ACM的区域赛金牌 觉得自己又行了 于是也想参与到奖学金的争夺中
 * 首先你的辅导员会通知你去打印你的获奖材料 然后高高兴兴拿给辅导员之后 辅导员又给了你一张表 让你打印了之后填写一下 包括你的个人信息还有一些个人介绍
 * 完成后 你本以为可以坐等发奖了 结果辅导员又跟你说我们评定还要去某某地方盖章 盖完章还要去找谁谁谁签字 最后还要参加一下答辩... 看着如此复杂的流程 你瞬间不想搞了
 *
 * 实际上我们生活中很多时候都是这这样 困难在办一件事情的时候 由于部门职能的不同 你得各个部门到处跑
 * 你肯定会抱怨一句 就不能有个人来统一一下吗 就不能在一个地方一起把事情都办了吗? 这时 我们就可以用都外观模式了
 *
 * 外观模式充分体现了迪米特法则 可能我们的整个项目有很多个子系统 但是我们可以在这些子系统的上面加一个门面(Facade)当我们外部需要与各个子系统交互时
 * 无需再去直接使用各个子系统 而是与门面进行交互 再由门面与后面的各个子系统操作 这样 我们以后需要办上面事情 就统一找门面就行了 这样的好处是
 * 首先肯定方便了代码的编写 统一找门面就行 不需要去详细了解子系统 并且 当子系统需要修改时 也只需要修改门面中的逻辑 不需要大面积的变动 遵循迪米特法则尽可能少的交互
 *
 *                                              Client
 *                                                |
 *                                                |
 *                                              Facade
 *                                                |
 *                              ------------------|------------------
 *                              |                 |                 |
 *                          SubSystem1        SubSystem1        SubSystem1
 *
 * 比如现在我们设计了三个子系统 分别是排队 结婚 领证 正常情况下我们是需要分别去找这三个部门去完成的 但是现在我们通过门面统一来完成:
 *                  public class SubSystemA {
 *
 *                      public void test1() {
 *                          System.out.println("排队");
 *                      }
 *
 *                  }
 *
 *                  public class SubSystemB {
 *
 *                      public void test2() {
 *                          System.out.println("结婚");
 *                      }
 *
 *                  }
 *
 *                  public class SubSystemC {
 *
 *                      public void test3() {
 *                          System.out.println("领证");
 *                      }
 *
 *                  }
 *
 * 现在三个系统太复杂了 我们添加一个门面:
 *                  public class Facade {
 *
 *                      SubSystemA a = new SubSystemA();
 *                      SubSystemB b = new SubSystemB();
 *                      SubSystemC c = new SubSystemC();
 *
 *                      public void marry() { // 红白喜事一条龙
 *                          a.test1();
 *                          b.test2();
 *                          c.test3();
 *                      }
 *
 *                  }
 *
 * 现在我们只需要一个门面就能直接把事情办完了:
 *                  public static void main(String[] args) {
 *
 *                      Facade facade = new Facade();
 *                      facade.marry();
 *
 *                  }
 *
 * 通过使用外观模式 我们就大大降低了类与类直接的关联程度 并且简化了流程
 */
public class Main {

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.marry();

    }

}
