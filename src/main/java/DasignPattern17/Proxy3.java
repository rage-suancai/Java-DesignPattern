package DasignPattern17;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author YXS
 * @PackageName: DasignPattern17
 * @ClassName: Proxy3
 * @Desription:
 * @date 2022/11/28 15:25
 */
public class Proxy3 implements MethodInterceptor {

    private final Object target;

    public Proxy3(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("现在是由CGlib进行代理操作" + o.getClass());
        return method.invoke(target, objects);

    }

}
