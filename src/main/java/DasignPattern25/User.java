package DasignPattern25;

/**
 * @author YXS
 * @PackageName: DasignPattern25
 * @ClassName: User
 * @Desription:
 * @date 2022/11/30 11:06
 */
public class User {

    String name;
    String tel;

    public User(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public User find(String address, Mediator mediator) {
        return mediator.find(address);
    }

    @Override
    public String toString() {
        return name + "(电话: " + tel + ")";
    }

}
