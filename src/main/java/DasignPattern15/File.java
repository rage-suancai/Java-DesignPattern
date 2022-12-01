package DasignPattern15;

/**
 * @author YXS
 * @PackageName: DasignPattern15
 * @ClassName: File
 * @Desription:
 * @date 2022/11/28 9:34
 */
public class File extends Component {

    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void test() {
        System.out.println("文件名称修改成功: " + this);
    }

}
