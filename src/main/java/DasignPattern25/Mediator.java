package DasignPattern25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YXS
 * @PackageName: DasignPattern25
 * @ClassName: Mediator
 * @Desription:
 * @date 2022/11/30 10:57
 */
public class Mediator {

    private final Map<String, User> userMap = new HashMap<>();

    public void register(String address, User user) {
        userMap.put(address, user);
    }

    public User find(String address) {
        return userMap.get(address);
    }

}
