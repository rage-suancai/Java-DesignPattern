package DasignPattern30;

/**
 * @author YXS
 * @PackageName: DasignPattern30
 * @ClassName: Family
 * @Desription:
 * @date 2022/12/1 9:36
 */
public class Family implements Visitor {

    @Override
    public void visit(Prize prize) {
        System.out.println("孩子 辛苦了 有没有好好照顾自己啊");
        System.out.println("你得了什么奖啊? " + prize.name + " 很不错 要继续加油啊");
    }

}
