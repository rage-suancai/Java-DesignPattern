package DasignPattern26;

import java.util.Random;

/**
 * @author YXS
 * @PackageName: DasignPattern26
 * @ClassName: Student
 * @Desription:
 * @date 2022/11/30 15:11
 */
public class Student {

    private String currentWork;
    private int percentage;

    public void work(String currentWork) {
        this.currentWork = currentWork;
        this.percentage = new Random().nextInt(100);
    }

    @Override
    public String toString() {
        return "我现在正在" + currentWork + "(进度: " + percentage + "%)";
    }

    public State save() {
        return new State(currentWork, percentage);
    }

    public void restore(State state) {
        this.currentWork = state.currentWork;
        this.percentage = state.percentage;
    }

}
