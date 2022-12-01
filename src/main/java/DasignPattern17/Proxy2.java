package DasignPattern17;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author YXS
 * @PackageName: DasignPattern17
 * @ClassName: Proxy2
 * @Desription:
 * @date 2022/11/28 14:33
 */
public class Proxy2 implements InvocationHandler {

    private final Object object;

    public Proxy2(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理的对象: " + proxy.getClass());
        Object res = method.invoke(object, args);
        System.out.println("方法调用完成, 返回值为: " + res);
        return res;

    }

}
