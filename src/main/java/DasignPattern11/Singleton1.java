package DasignPattern11;

/**
 * @author YXS
 * @PackageName: DasignPattern11
 * @ClassName: Singleton
 * @Desription:
 * @date 2022/11/24 16:53
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
