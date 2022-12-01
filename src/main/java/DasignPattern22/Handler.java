package DasignPattern22;

import java.util.Optional;

/**
 * @author YXS
 * @PackageName: DasignPattern22
 * @ClassName: Handler
 * @Desription:
 * @date 2022/11/29 11:36
 */
public abstract class Handler {

    protected Handler successor;

    public Handler connect(Handler successor) {

        this.successor = successor;
        return successor;

    }

    public void handler() {

        this.doHandle();
        Optional
                .ofNullable(successor)
                .ifPresent(Handler::handler);

    }

    public abstract void doHandle();

}
