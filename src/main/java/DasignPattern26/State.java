package DasignPattern26;

/**
 * @author YXS
 * @PackageName: DasignPattern26
 * @ClassName: State
 * @Desription:
 * @date 2022/11/30 15:30
 */
public class State {

    final String currentWork;
    final int percentage;

    State (String currentWork, int percentage) {
        this.currentWork = currentWork;
        this.percentage = percentage;
    }

}
