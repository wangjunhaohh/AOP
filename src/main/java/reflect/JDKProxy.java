package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces= {UserDao.class};
//        UserDao dao=(UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return method.invoke(new UserDaoImp1(),args);
//            }
//        });
        UserDaoImp1 userDao=new UserDaoImp1();
        UserDao dao=(UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces,new  UserDaoProxy(userDao));
        int result=dao.add(1,2);
        System.out.println(result);
        System.out.println(dao.update("asd"));
    }
}
class UserDaoProxy implements InvocationHandler{
    private Object obj;
    //有参数构造的传递
    public UserDaoProxy(Object obj){
        this.obj=obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前执行
        System.out.println("方法之前执行..."+method.getName()+":传递的参数..."+ Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(obj,args);

        //方法之后
        System.out.println("方法之后..."+obj);


        return res;
    }
}