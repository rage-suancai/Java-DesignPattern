package DasignPattern19;

/**
 * @author YXS
 * @PackageName: DasignPattern19
 * @ClassName: UserService
 * @Desription:
 * @date 2022/11/28 17:47
 */
public class UserService {

    public void service() {
        DBUtil util = DBUtilFactory.getFlyweight();
        util.selectDB();
    }

}
