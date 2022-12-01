package DasignPattern3;

/**
 * @author YXS
 * @PackageName: DasignPattern3
 * @ClassName: Coder
 * @Desription:
 * @date 2022/11/22 16:21
 */
public abstract class Coder {

    public abstract void coding();

    class JavaCoder extends Coder {
        public void game() {
            System.out.println("艾欧里亚最强王者已上号");
        }

        public void coding() {
            System.out.println("摆烂了 啊对对对");
        }
    }

}
