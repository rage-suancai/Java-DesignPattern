package DasignPattern11;

/**
 * @author YXS
 * @PackageName: DasignPattern11
 * @ClassName: Singleton2
 * @Desription:
 * @date 2022/11/24 17:10
 */
public class Singleton2 {

    private static Singleton2 INSTANCE;
    /*private static class Holder {
        private final static Singleton2 INSTANCE = new Singleton2();
    }*/

    private Singleton2() {}

    static synchronized Singleton2 getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;

    }

    /*static Singleton2 getInstance() {

        if (INSTANCE == null) {
            synchronized (Singleton2.class) {
                INSTANCE = new Singleton2();
            }
        }
        return INSTANCE;

    }*/

    /*static Singleton2 getInstance() {

        if (INSTANCE == null) {
            synchronized (Singleton2.class) {
                if (INSTANCE == null) INSTANCE = new Singleton2();
            }
        }
        return INSTANCE;

    }*/

    /*static Singleton2 getInstance() {
        return Holder.INSTANCE;
    }*/

}
