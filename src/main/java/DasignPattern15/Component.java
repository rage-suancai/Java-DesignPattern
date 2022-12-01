package DasignPattern15;

/**
 * @author YXS
 * @PackageName: DasignPattern15
 * @ClassName: Component
 * @Desription:
 * @date 2022/11/28 9:22
 */
public abstract class Component {

    public abstract void addComponent(Component component);
    public abstract void removeComponent(Component component);
    public abstract Component getChild(int index);
    public abstract void test();

}
