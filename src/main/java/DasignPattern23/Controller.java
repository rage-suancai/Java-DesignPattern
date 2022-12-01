package DasignPattern23;

/**
 * @author YXS
 * @PackageName: DasignPattern23
 * @ClassName: Controller
 * @Desription:
 * @date 2022/11/29 16:46
 */
public class Controller {

    static void callAC(Command Command) {
        Command.executeAC();

    }

    static void CallOFF(Command Command) {
        Command.executeOFF();
    }

}
