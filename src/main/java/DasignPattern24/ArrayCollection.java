package DasignPattern24;

import java.util.Iterator;

/**
 * @author YXS
 * @PackageName: DasignPattern24
 * @ClassName: ArrayCollection
 * @Desription:
 * @date 2022/11/29 17:36
 */
public class ArrayCollection<T> implements Iterable<T> {

    private final T[] array;

    private ArrayCollection(T[] array) {
        this.array = array;
    }

    public static <T> ArrayCollection<T> of(T[] array) {
        return new ArrayCollection<>(array);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<T> {

        private int cur = 0;

        @Override
        public boolean hasNext() {
            return cur < array.length;
        }

        @Override
        public T next() {
            return array[cur++];
        }

    }

}
