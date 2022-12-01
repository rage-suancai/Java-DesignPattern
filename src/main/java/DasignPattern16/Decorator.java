package DasignPattern16;

/**
 * @author YXS
 * @PackageName: DasignPattern16
 * @ClassName: Decorator
 * @Desription:
 * @date 2022/11/28 10:13
 */
public class Decorator extends Base {

    protected Base base;

    public Decorator(Base base) {
        this.base = base;
    }

    @Override
    public void test() {
        base.test();
    }

}
