package DasignPattern8;

/**
 * @author YXS
 * @PackageName: DasignPattern8
 * @ClassName: Fruit
 * @Desription:
 * @date 2022/11/24 9:55
 */
public abstract class Fruit {

    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String toString() {
        return name + "@" + hashCode();
    }

}
