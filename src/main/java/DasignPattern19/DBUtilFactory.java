package DasignPattern19;

/**
 * @author YXS
 * @PackageName: DasignPattern19
 * @ClassName: DBUtilFactory
 * @Desription:
 * @date 2022/11/28 17:42
 */
public class DBUtilFactory {

    private static final DBUtil UTIL = new DBUtil();

    public static DBUtil getFlyweight() {
        return UTIL;
    }

}
