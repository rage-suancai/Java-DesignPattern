package DasignPattern8;

/**
 * @author YXS
 * @PackageName: DasignPattern8
 * @ClassName: AppleFactory
 * @Desription:
 * @date 2022/11/24 10:49
 */
public class AppleFactory extends FruitFactory<Apple> {

    @Override
    public Apple getFruit() {
        return new Apple();
    }

}
