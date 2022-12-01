package DasignPattern8;

/**
 * @author YXS
 * @PackageName: DasignPattern8
 * @ClassName: FruitFactory
 * @Desription:
 * @date 2022/11/24 10:11
 */
public abstract class FruitFactory<T extends Fruit> {
    public abstract T getFruit();
}
