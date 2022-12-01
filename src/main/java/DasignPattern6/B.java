package DasignPattern6;

/**
 * @author YXS
 * @PackageName: DasignPattern6
 * @ClassName: B
 * @Desription:
 * @date 2022/11/23 15:00
 */
public class B {

    A a;
    public B(A a) {
        this.a = a;
    }

    public void test() {
        System.out.println("我是B的方法 我也需要连接数据库");
        a.connectDatabase();
    }

}
