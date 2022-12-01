package DasignPattern28;

/**
 * @author YXS
 * @PackageName: DasignPattern28
 * @ClassName: Student
 * @Desription:
 * @date 2022/11/30 17:08
 */
public class Student {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void study() {
        switch (state) {
            case LAZY : System.out.println("只要我不努力 老板就别想过上想要的生活 开摆"); break;
            case NORMAL: System.out.println("拼搏百天 我要上清华大学"); break;
        }
    }

}
