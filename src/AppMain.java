import beans.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class AppMain {

    public static String xmlName = "spring-config.xml";
    public static String basicBeanName = "helloworld";

    public static void main(String[] args) {
        HelloWorld();  // hello world!
        IOCtest1(); // 已经过时
        IOCtest2(); // 几种容器
        IOCtest3(); // bean 的配置
        IOCtest4(); // bean 作用域
        IOCtest5(); // bean 生命周期
      //  IOCtest6(); // bean  hook
        IOCtest7(); // bean 继承
    }

    public static void HelloWorld(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        HelloWorldBean helloWorldBean = (HelloWorldBean) context.getBean(basicBeanName);
        System.out.println(helloWorldBean.getMsg());
    }

    public static void IOCtest1(){
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(xmlName));
        HelloWorldBean helloWorldBean = (HelloWorldBean) factory.getBean(basicBeanName);
        System.out.println(helloWorldBean.getMsg());
    }
    public static void IOCtest2() {
        ApplicationContext fileSystemResource = new FileSystemXmlApplicationContext("E:\\MySpringDown\\resource\\spring-config.xml");//该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供给构造器 XML 文件的完整路径。
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName); //该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件。
        HelloWorldBean helloWorldBean1 = (HelloWorldBean) fileSystemResource.getBean(basicBeanName);
        HelloWorldBean helloWorldBean2 = (HelloWorldBean) context.getBean(basicBeanName);
        System.out.println(helloWorldBean1.getMsg());
        System.out.println(helloWorldBean2.getMsg());
    }

    public static void IOCtest3(){

        // 启动时创建
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        BeanAttr beanAttr1 = (BeanAttr) context.getBean("beanattr1");
        System.out.println(beanAttr1.getMsg());

        //	这个属性指定唯一的 bean 标识符。在基于 XML 的配置元数据中，你可以使用 ID 和/或 name 属性来指定 bean 标识符。
        //    <bean id="beanattr" class="beans.BeanAttr">
        //        <property name="msg" value="Bean Attr Learn"></property>
        //    </bean>


        // 延迟初始化的 bean 告诉 IoC 容器在它第一次被请求时，而不是在启动时去创建一个 bean 实例。
        //     <bean id="beanattr2" class="beans.BeanAttr" lazy-init="true">
        //        <property name="msg" value="Bean Attr Learn"></property>
        //    </bean>
        // 访问时创建
        BeanAttr beanAttr2 = (BeanAttr) context.getBean("beanattr2");
        System.out.println(beanAttr2.getMsg());

    }

    public static void IOCtest4(){
        
        // 单例返回
        // <bean id="beanscope1" class="beans.BeanScope" scope="singleton"></bean>
        
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        BeanScope beanScope1 = (BeanScope) context.getBean("beanscope1");
        BeanScope beanScope2 = (BeanScope) context.getBean("beanscope1");
        beanScope1.setMsg("object A");
        System.out.println(beanScope1.getMsg());
        System.out.println(beanScope2.getMsg());
        
        // 返回新对象
        //<bean id="beanscope2" class="beans.BeanScope" scope="prototype"></bean>
        BeanScope beanScope3 = (BeanScope) context.getBean("beanscope2");
        BeanScope beanScope4 = (BeanScope) context.getBean("beanscope2");
        beanScope3.setMsg("prototype object A");
        System.out.println(beanScope3.getMsg());
        System.out.println(beanScope4.getMsg());

    }

    public static void IOCtest5(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        BeanLife beanLife = (BeanLife) context.getBean("beanlife");
        System.out.println(beanLife.getMsg());
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

        //如果你有太多具有相同名称的初始化或者销毁方法的 Bean，那么你不需要在每一个 bean 上声明初始化方法和销毁方法。
        //框架使用 元素中的 default-init-method 和 default-destroy-method 属性提供了灵活地配置这种情况
        //<beans xmlns="http://www.springframework.org/schema/beans"
        //    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        //    xsi:schemaLocation="http://www.springframework.org/schema/beans
        //    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
        //    default-init-method="init"
        //    default-destroy-method="destroy">
        //
        //   <bean id="..." class="...">
        //       <!-- collaborators and configuration for this bean go here -->
        //   </bean>
        //
        //</beans>
    }

    public static void IOCtest6(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        BeanBigHook beanLife = (BeanBigHook) context.getBean("beanhook");
        System.out.println(beanLife.getMsg());
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }

    public static void IOCtest7(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        BeanSon beanSon = (BeanSon) context.getBean("beanson");
        System.out.println(beanSon.getMsg1());
        System.out.println(beanSon.getMsg2());
        System.out.println(beanSon.getMsg3());
    }
}
