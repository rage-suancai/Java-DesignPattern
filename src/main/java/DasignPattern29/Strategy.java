package DasignPattern29;

import java.util.Arrays;

/**
 * @author YXS
 * @PackageName: DasignPattern29
 * @ClassName: Strategy
 * @Desription:
 * @date 2022/12/1 8:59
 */
public interface Strategy {

    Strategy SINGLE = Arrays::sort;
    Strategy PARALLEL = Arrays::parallelSort;

    void sort(int[] array);

}
