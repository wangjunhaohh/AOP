package test;

import aopanno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testAopanno(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        User user=context.getBean("user",User.class);
        user.add();
    }
}
