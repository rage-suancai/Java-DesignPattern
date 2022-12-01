package DasignPattern13;

/**
 * @author YXS
 * @PackageName: DasignPattern13
 * @ClassName: TestAdapter
 * @Desription:
 * @date 2022/11/25 15:18
 */
public class TestAdapter implements Target{

    TestSupplier supplier;

    public TestAdapter(TestSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String supply() {
        return supplier.doSupply();
    }

}
