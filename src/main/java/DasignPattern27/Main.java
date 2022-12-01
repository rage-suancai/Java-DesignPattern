package DasignPattern27;

/**
 * 观察者模式
 * 牵一发而动全身 一副有序摆放的多米洛骨牌 在我们推到第一个骨牌时 后面的骨牌会不断地被上一个骨牌推倒
 *
 * 在Java中 一个对象的状态发生改变 可能就会影响到其他的对象 与之相关的对象可能也会联动的进行改变 还有我们之前遇到过的监听器机制 当具体的事件触发时
 * 我们在一开始创建的监听器就可以执行相关的逻辑 我们可以使用观察者模式来实现这样的功能 当对象发生改变时 观察者能够立即观察倒并进行一下联动操作 我们先定义一个观察者接口
 *                  public interface Observer { // 观察者接口
 *                      void update(); // 当对象有更新时 会回调此方法
 *                  }
 *
 * 接着我们来写一个支持观察者的实体类:
 *                  public class Subject {
 *
 *                      private final Set<Observer> observerSet = new HashSet<>();
 *
 *                      public void observe(Observer observer) { // 添加观察者
 *                          observerSet.add(observer);
 *                      }
 *
 *                      public void modify() { // 模拟对象进行修改
 *                          observerSet.forEach(Observer::update); // 当对象发生修改时 会通知所有的观察者 并进行方法回调
 *                      }
 *
 *                  }
 *
 * 接着我就可以测试一下了:
 *                  public static void main(String[] args) {
 *
 *                      Subject subject = new Subject();
 *                      subject.observe(() -> System.out.println("我是一号观察者"));
 *                      subject.observe(() -> System.out.println("我是二号观察者"));
 *                      subject.modify();
 *
 *                  }
 *
 * 这样 我们就简单实现了一下观察者模式 当然JDK也为我们提供了实现观察者模式相关的接口:
 *                  import java.util.Observable; // java.util包下提供的观察者抽象类
 *
 *                  public class Subject extends Observable() {
 *
 *                      public void modify() {
 *                          System,out.println("对对象进行修改");
 *                          this.setChanged(); // 当对对象修改后 需要setChanged来设定为已修改状态
 *                          this.notifyObservers(new Date()); // 使用notifyObservers方法来通知所有的观察者
 *                          // 注意只有已修改状态下通知观察者才会有效并且可以给观察者传递参数 这里传递了一个时间对象
 *                      }
 *
 *                  }
 *
 * 我们来测试一下吧:
 *                  public static void main(String[] args) {
 *
 *                      Subject subject = new Subject();
 *                      subject.addObserver((o, arg) -> System.out.println("监听到变化 并得到参数: " + arg));
 *                      // 注意: 这里的Observer是java.util包下提供的
 *                      subject.modify(); // 进行修改操作
 *
 *                  }
 */
public class Main {

    public static void main(String[] args) {

        /*Subject subject = new Subject();
        subject.observe(() -> System.out.println("我是一号观察者"));
        subject.observe(() -> System.out.println("我是二号观察者"));
        subject.modify();*/

        Subject subject = new Subject();
        subject.addObserver((o, arg) -> System.out.println("监听到变化 并得到参数: " + arg));
        subject.modify();

    }

}
