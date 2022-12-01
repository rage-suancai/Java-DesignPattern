package DasignPattern27;

import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * @author YXS
 * @PackageName: DasignPattern27
 * @ClassName: Subject
 * @Desription:
 * @date 2022/11/30 16:14
 */
public class Subject extends Observable {

    private final Set<Observer> observerSet = new HashSet<>();

    public void observe(Observer observer) {
        observerSet.add(observer);
    }

    /*public void modify() {
        observerSet.forEach(Observer::update);
    }*/

    public void modify() {
        System.out.println("对对象进行修改");
        this.setChanged();
        this.notifyObservers(new Date());
    }

}
