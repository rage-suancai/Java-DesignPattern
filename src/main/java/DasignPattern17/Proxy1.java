package DasignPattern17;

/**
 * @author YXS
 * @PackageName: DasignPattern17
 * @ClassName: Proxy
 * @Desription:
 * @date 2022/11/28 11:24
 */
public class Proxy1 extends Subject1 {

    Subject1 target;

    public Proxy1(Subject1 subject) {
        this.target = subject;
    }

    @Override
    public void test() {
        System.out.println("代理前绕方法");
        target.test();
        System.out.println("代理后绕方法");
    }

}
