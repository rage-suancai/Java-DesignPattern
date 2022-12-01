package DasignPattern30;

/**
 * @author YXS
 * @PackageName: DasignPattern30
 * @ClassName: Boss
 * @Desription:
 * @date 2022/12/1 9:30
 */
public class Boss implements Visitor {

    @Override
    public void visit(Prize prize) {
        System.out.println("你的奖大么? 能够为公司带来什么效益么?");
        System.out.println("还不如老老实实加班给我多干干 别去搞这些没用的");
    }

}
