package DasignPattern21;

/**
 * 模板方法模式
 * 模板方法模式我们之前也见到过许多 我们先来看看什么是模板方法
 *
 * 有些时候 我们的业务可能需要经历很多个步骤来完成 比如我们生病了在医院看病 首先是去门诊挂号 然后是去找医生看病 确定病因后
 * 就根据医生的处方去前台开药 最后付钱 这一整套流程看似是规规矩矩的 但是在这其中 某些步骤并不是确定的 比如医生看病这一步
 * 由于不同的病因 可能会进行不同的处理 最后开出来的药方也会不同 所以 整套流程中 有些操作是固定的 有操作可能需要根据具体情况而定
 *
 * 在我们的程序中也是如此 可能某些操作是固定的 我们就可以直接在类中对应方法进行编写 但是可能某些操作需要视情况而定
 * 由于不同的子类实现来决定 这时 我们就需要让这些操作由子类来延迟实现了 现在我们就需要用到模板方法模式
 *
 * 我们先来写个例子:
 *                  public abstract class AbstractDiagnosis { // 抽象诊断方法 因为现在只知道挂号和看医生是固定模式 剩下的开处方和拿药都是不确定的
 *
 *
 *                      public void test() {
 *
 *                          System.out.println("今天头好晕 不想起床 开摆 先跟公司请个假");
 *                          System.out.println("去医院看病了~");
 *                          System.out.println("1 >> 先挂号");
 *                          System.out.println("2 >> 等待叫号");
 *                          // 由于现在不知道该开什么处方 所以只能先定义一下行为 然后具体由子类实现
 *                          // 大致的流程先定义好就行
 *                          this.prescribe();
 *                          this.medicine(); // 开药同理
 *
 *                      }
 *
 *                      public abstract void prescribe(); // 开处方操作根据具体病症决定了
 *
 *                      public abstract void medicine(); // 拿药也是根据具体的处方去拿
 *
 *                  }
 *
 * 现在我们定义好了抽象方法 只是将具体的流程先定义出来了 但是部分方法需要根据实现决定:
 *                  public class ColdDiagnosis extends AbstractDiagnosis { // 感冒相关的具体实现子类
 *
 *                      @Override
 *                      public void prescribe() {
 *                          System.out.println("3 >> 一眼丁真 鉴定为假 你这不是感冒 纯粹是想摆烂");
 *                      }
 *
 *                      @Override
 *                      public void medicine() {
 *                          System.out.println("4 >> 开点头孢回去吃吧");
 *                      }
 *
 *                  }
 *
 * 这样 我们就有了一个具体的实现类 并且由于看病逻辑已经由父类定义好了 所以子类只需要实现需要的部分即可 这样我们就实现了简单的模板方法模式:
 *                  public static void main(String[] args) {
 *
 *                      AbstractDiagnosis diagnosis = new ColdDiagnosis();
 *                      diagnosis.test();
 *
 *                  }
 *
 *                  今天头好晕 不想起床 开摆 先跟公司请个假
 *                  去医院看病了~
 *                  1 >> 先挂号
 *                  2 >> 等待叫号
 *                  3 >> 一眼丁真 鉴定为假 你这不是感冒 纯粹是想摆烂
 *                  4 >> 开点头孢回去吃吧
 *
 * 最后我们来看看在JUC中讲解AQS源码实现中出现的代码:
 *                  public final boolean release(int arg) { // AQS的锁释放操作
 *                      // 可以看到这里调用了tryRelease方法 但是此方法并不是在AQS实现的 而是不同的锁自行实现 因为AQS也不知道你这种类型的锁到底该怎么去解锁
 *                      if (tryRelease(arg)) {
 *                          Node h = head;
 *                          if(h != null && h.waitStatus != 0)
 *                              unparkSuccessor(h);
 *                          return true;
 *                      }
 *                      return false;
 *                  }
 *
 *                  protected boolean tryRelease(int arg) {
 *                      throw new UnsupportedOperationException(); // AQS中不支持 需要延迟到具体子类去实现
 *                  }
 *
 * 模板方法模式 实际上部分功能的实现是在子类完成的:
 *                  protected final boolean tryRelease(int releases) {
 *                      int c = getState() - releases;
 *                      if (Thread.currentThread() != getExclusiveOwnerThread())
 *                          throw new IllegalMonitorStateException();
 *                      boolean free = false;
 *                      if (c == 0) {
 *                          free = true;
 *                          setExclusiveOwnerThread(null);
 *                      }
 *                      setState(c);
 *                      return free;
 *                  }
 *
 * 是不是感觉 这种层层套娃的写法 好像并不是这些大佬故意为了装逼才这样写的 而是真的在遵守规范编写 让代码更易懂一些
 * 甚至你现在咋回去推一遍会发现思路非常清晰 当然 除了这里之外 还有很多框架都使用了模板方法模式来设计类结构 还请各位小伙伴自行探索
 */
public class Main {

    public static void main(String[] args) {

        AbstractDiagnosis diagnosis = new ColdDiagnosis();
        diagnosis.test();

    }

}
