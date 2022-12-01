package DasignPattern16;

/**
 * @author YXS
 * @PackageName: DasignPattern16
 * @ClassName: DecoratorImpl
 * @Desription:
 * @date 2022/11/28 10:19
 */
public class DecoratorImpl extends Decorator {

    public DecoratorImpl(Base base) {
        super(base);
    }

    @Override
    public void test() {

        System.out.println("装饰方法: 我是操作前逻辑");
        super.test();
        System.out.println("装饰方法: 我是操作后逻辑");

    }

}
