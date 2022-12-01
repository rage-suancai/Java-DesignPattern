package DasignPattern23;

/**
 * @author YXS
 * @PackageName: DasignPattern23
 * @ClassName: Command
 * @Desription:
 * @date 2022/11/29 16:40
 */
public abstract class Command {

    private final Receiver receiver;

    protected Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public void executeAC() {
        receiver.action();
    }

    public void executeOFF() {
        receiver.off();
    }

}
