package DasignPattern30;

/**
 * @author YXS
 * @PackageName: DasignPattern30
 * @ClassName: Classmate
 * @Desription:
 * @date 2022/12/1 9:33
 */
public class Classmate implements Visitor {

    @Override
    public void visit(Prize prize) {
        System.out.println("你得了" + prize.name + "奖啊 还可以");
        System.out.println("不过这个奖没什么含金量 下次别去了");
    }

}
