package DasignPattern21;

/**
 * @author YXS
 * @PackageName: DasignPattern21
 * @ClassName: AbstractDiagnosis
 * @Desription:
 * @date 2022/11/29 9:52
 */
public abstract class AbstractDiagnosis {

    public void test() {

        System.out.println("今天头好晕 不想起床 开摆 先跟公司请个假");
        System.out.println("去医院看病了~");
        System.out.println("1 >> 先挂号");
        System.out.println("2 >> 等待叫号");

        this.prescribe();
        this.medicine();

    }

    public abstract void prescribe();

    public abstract void medicine();

}
