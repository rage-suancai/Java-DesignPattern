package DasignPattern14;

/**
 * @author YXS
 * @PackageName: DasignPattern14
 * @ClassName: KissTea
 * @Desription:
 * @date 2022/11/25 17:14
 */
public class KissTea extends RefinedAbstractTea {

    protected KissTea(Size size) {
        super(size);
    }

    @Override
    public String getType() {
        return "美式炭烧咖啡";
    }

}
