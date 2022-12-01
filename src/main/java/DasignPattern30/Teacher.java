package DasignPattern30;

/**
 * @author YXS
 * @PackageName: DasignPattern30
 * @ClassName: Teacher
 * @Desription:
 * @date 2022/12/1 9:26
 */
public class Teacher implements Visitor {

    @Override
    public void visit(Prize prize) {
        System.out.println("你得奖是什么奖?" + prize.name);
        System.out.println("你得了几等奖?" + prize.level);
    }

}
