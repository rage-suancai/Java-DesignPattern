package DasignPattern29;

/**
 * @author YXS
 * @PackageName: DasignPattern29
 * @ClassName: Sorter
 * @Desription:
 * @date 2022/12/1 9:02
 */
public class Sorter {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] array) {
        strategy.sort(array);
    }

}
