package DasignPattern15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YXS
 * @PackageName: DasignPattern15
 * @ClassName: Directory
 * @Desription:
 * @date 2022/11/28 9:29
 */
public class Directory extends Component {

    List<Component> child = new ArrayList<>();

    @Override
    public void addComponent(Component component) {
        child.add(component);
    }

    @Override
    public void removeComponent(Component component) {
        child.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return child.get(index);
    }

    @Override
    public void test() {
        child.forEach(Component::test);
    }

}
