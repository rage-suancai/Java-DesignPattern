package DasignPattern18;

/**
 * @author YXS
 * @PackageName: DasignPattern19
 * @ClassName: Facade
 * @Desription:
 * @date 2022/11/28 17:13
 */
public class Facade {

    SubSystemA a = new SubSystemA();
    SubSystemB b = new SubSystemB();
    SubSystemC c = new SubSystemC();

    public void marry() {
        a.test1();
        b.test2();
        c.test3();
    }

}
