package DasignPattern23;

/**
 * @author YXS
 * @PackageName: DasignPattern23
 * @ClassName: AirConditioner
 * @Desription:
 * @date 2022/11/29 16:50
 */
public class AirConditioner implements Receiver{

    @Override
    public void action() {
        System.out.println("空调已开启 呼呼呼~");
    }

    @Override
    public void off() {
        System.out.println("空调已关闭");
    }

}
