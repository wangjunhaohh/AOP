package aopanno;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"aopanno"})
@EnableAspectJAutoProxy(proxyTargetClass = true)//默认是false false jdk代理
public class ConfigAop {

}
