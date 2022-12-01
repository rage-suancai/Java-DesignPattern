package DasignPattern14;

/**
 * @author YXS
 * @PackageName: DasignPattern14
 * @ClassName: RefinedAbstractTea
 * @Desription:
 * @date 2022/11/25 17:02
 */
public abstract class RefinedAbstractTea extends AbstractTea {

    protected RefinedAbstractTea(Size size) {
        super(size);
    }

    public String getSize() {
        return size.getSize();
    }

}
