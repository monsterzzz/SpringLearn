import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhujiebean.*;

public class zhujieMain {
    private static final String xmlName = "thirdConfig.xml";

    public static void main(String[] args) {
        zhujieTest1(); // @Required
        //    <bean id="second" class="zhujiebean.ByNamebean" autowire="byName">
        //        <!--<property name="dog" ref="Dog"></property>-->
        //    </bean>
        //
        //    <bean id="third" class="zhujiebean.ByTypebean" autowire="byType">
        //        <!--<property name="dog" ref="Dog"></property>-->
        //    </bean>
        //
        //    <bean id="four" class="zhujiebean.ByConstructorbean" autowire="constructor">
        //
        //    </bean>
        //zhujieTest2();  // ByName
        //zhujieTest3();  // ByType
        //zhujieTest4(); // ByConstructor
        //zhujieTest5();
        zhujieTest6();

    }

    public static void zhujieTest1(){
        // @Required
        //    public void setPassword(String password) {
        //        this.password = password;
        //    }

        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        Requiredbean requiredbean = (Requiredbean) context.getBean("first");
        System.out.println(requiredbean.getName());
    }

    public static void zhujieTest2(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        ByNamebean byNamebean = (ByNamebean) context.getBean("second");
        System.out.println(byNamebean.getDog());
    }

    public static void zhujieTest3(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        ByTypebean byTypebean = (ByTypebean) context.getBean("third");
        System.out.println(byTypebean.getDog());
    }

    public static void zhujieTest4(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        ByConstructorbean byConstructorbean = (ByConstructorbean) context.getBean("four");
        System.out.println(byConstructorbean.getDog());
    }

    public static void zhujieTest5(){
        // note: <context:annotation-config/>
        // 要启用注解才能使用
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        Autowirebean autowirebean = (Autowirebean) context.getBean("five");
        autowirebean.dogSay();
        System.out.println(autowirebean.getDog());
    }

    public static void zhujieTest6(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        Qubean qubean = (Qubean) context.getBean("qubean");
        System.out.println(qubean.getDog().getName());
    }

    public static void zhujieTest7(){
        // @PostConstruct 作为 xml init-method 的代替
        // @PreDestroy  作为 xml destroy-method 的代替
        // @Resource - ByName
        // @Autowire - ByType
    }

}
