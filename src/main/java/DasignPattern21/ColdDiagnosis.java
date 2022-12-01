package DasignPattern21;

/**
 * @author YXS
 * @PackageName: DasignPattern21
 * @ClassName: ColdDiagnosis
 * @Desription:
 * @date 2022/11/29 10:27
 */
public class ColdDiagnosis extends AbstractDiagnosis {

    @Override
    public void prescribe() {
        System.out.println("3 >> 一眼丁真 鉴定为假 你这不是感冒 纯粹是想摆烂");
    }

    @Override
    public void medicine() {
        System.out.println("4 >> 开点头孢回去吃吧");
    }

}
