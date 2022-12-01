package DasignPattern29;

import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 策略模式
 * 对面卡兹克打野被开了 我们是去打小龙呢还是打大龙呢? 这就要看我们团队这一局的打法策略了
 *
 * 我们可以为对象设定一种策略这样对象之后的行为就会按照我们在一开始指定的策略而决定了 看起来和前面的状态模式很像
 * 但是 它与模式的区别在于 这种转换是"主动"的 是由我们去指定 而状态模式 可能是在运行过程中自动切换的
 *
 * 其实策略模式我们之前也遇到过 比如线程池的拒绝策略:
 *                  public static void main(String[] args) {
 *
 *                      ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
 *                              TimeUnit.SECONDS, new SynchronousQueue<>(), // 这里不给排队
 *                              new ThreadPoolExecutor.AbortPolicy()); // 当线程池无法再继续创建新的任务时 我们可以自由决定使用什么拒绝策略
 *
 *                      Runnable runnable = () -> {
 *                          try {
 *                              TimeUnit.SECONDS.sleep(60);
 *                          } catch (InterruptedException e) {
 *                              throw new RuntimeException(e);
 *                          }
 *                      };
 *                      executor.execute(runnable); // 连续提交两次任务 肯定塞不下 这时就得走拒绝了
 *                      executor.execute(runnable);
 *
 *                  }
 *
 * 可以看到 我们如果使用AbortPolicy 那么就是直接抛出异常:
 *                  Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task DasignPattern29.Main$$Lambda$16/0x0000000800c01a00@27d6c5e0 rejected from java.util.concurrent.ThreadPoolExecutor@4f3f5b24[Running, pool size = 1, active threads = 1, queued tasks = 0, completed tasks = 0]
 * 	                at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2065)
 * 	                at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:833)
 * 	                at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1365)
 * 	                at DasignPattern29.Main.main(Main.java:53)
 *
 * 我们也可以使用其他的策略:
 *                  ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
 *                          TimeUnit.SECONDS, new SynchronousQueue<>(),
 *                          new ThreadPoolExecutor.DiscardOldestPolicy());
 *
 * 这种策略就会从等待队列中踢出一个之前的 不过我们这里的等待队列是没有容量的那种 所以会直接炸掉:
 *                  Exception in thread "main" java.lang.StackOverflowError<1,024个内部行>
 *
 * 至于具体原因 可以回去看看JUC篇
 *
 * 再比如我们现在有一个排序类 但是根据不同的策略 会使用不同的排序方案:
 *                  public interface Strategy { // 策略接口 不同的策略实现也不同
 *
 *                      Strategy SINGLE = Arrays::sort; // 单线程排序方案
 *                      Strategy PARALLEL = Arrays::parallelSort; // 并行排序方案
 *
 *                      void sort(int[] array);
 *
 *                  }
 *
 * 现在我们编写一个排序类:
 *                  public class Sorter {
 *
 *                      private Strategy strategy; // 策略
 *
 *                      public void setStrategy(Strategy strategy) {
 *                          this.strategy = strategy;
 *                      }
 *
 *                      public void sort(int[] array) {
 *                          strategy.sort(array);
 *                      }
 *
 *                  }
 *
 * 现在我们就可以指定不同的策略进行排序了:
 *                  public static void main(String[] args) {
 *
 *                      Sorter sorter = new Sorter();
 *                      sorter.setStrategy(Strategy.PARALLEL); // 指定为并行排序方案
 *                      sorter.sort(new int[] {9, 2, 4, 5, 1, 0, 3, 7});
 *
 *                  }
 */
public class Main {

    public static void main(String[] args) {

        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new SynchronousQueue<>(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        executor.execute(runnable);
        executor.execute(runnable);*/

        Sorter sorter = new Sorter();
        sorter.setStrategy(Strategy.PARALLEL);
        sorter.sort(new int[] {9, 2, 4, 5, 1, 0, 3, 7});

    }

}
