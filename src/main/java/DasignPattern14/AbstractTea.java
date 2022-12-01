package DasignPattern14;

/**
 * @author YXS
 * @PackageName: DasignPattern14
 * @ClassName: AbstractTea
 * @Desription:
 * @date 2022/11/25 16:52
 */
public abstract class AbstractTea {

    protected Size size;

    protected AbstractTea(Size size) {
        this.size = size;
    }

    public abstract String getType();

}
