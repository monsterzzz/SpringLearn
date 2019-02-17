import DIbeans.ConBean2;
import funciton.ConFunciton;
import funciton.ConFunciton2;
import funciton.ConFunciton3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConMain {

    private static String xmlName = "secondConfig.xml";

    public static void main(String[] args) {
        DItest1(); // 想要向一个对象传递一个引用，你需要使用 标签的 ref 属性，如果你想要直接传递值，那么应该使用 value 属性
        DItest2(); // 设值注入
        DItest3(); // 注入内部bean
        DItest4(); // 注入集合

    }

    public static void DItest1(){
        //    <bean id="conbean" class="funciton.ConFunciton">
        //        <constructor-arg ref="conBean"></constructor-arg>
        //    </bean>
        //    <bean id="conBean" class="DIbeans.ConBean"></bean>
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        ConFunciton conFunciton = (ConFunciton) context.getBean("conbean");
        conFunciton.doThing();
    }

    public static void DItest2(){
        //<bean id="conBean" class="DIbeans.ConBean"></bean>
        //
        //    <bean id="setbean" class="funciton.ConFunciton2">
        //        <property name="conBean" ref="conBean"></property>
        //    </bean>
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        ConFunciton2 conFunciton = (ConFunciton2) context.getBean("setbean");
        conFunciton.doThing();
    }

    public static void DItest3(){
        // <bean id="innerbean" class="funciton.ConFunciton3">
        //        <property name="conBean">
        //            <bean class="DIbeans.ConBean"></bean>
        //        </property>
        //    </bean>
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        ConFunciton3 conFunciton = (ConFunciton3) context.getBean("innerbean");
        conFunciton.doThing();
    }

    public static void DItest4(){
        //    <bean id="collectionbean" class="DIbeans.ConBean2">
        //        <property name="list">
        //            <list>
        //                <value>hello1</value>
        //                <value>hello2</value>
        //                <value>hello3</value>
        //                <value>hello4</value>
        //            </list>
        //        </property>
        //
        //        <property name="map">
        //            <map>
        //                <entry key="1" value="hello"></entry>
        //                <entry key="2" value="hello"></entry>
        //                <entry key="3" value="hello"></entry>
        //                <entry key="4" value="hello"></entry>
        //            </map>
        //        </property>
        //
        //        <property name="set">
        //            <set>
        //                <value>hello1</value>
        //                <value>hello2</value>
        //                <value>hello3</value>
        //                <value>hello1</value>
        //            </set>
        //        </property>
        //
        //        <property name="properties">
        //            <props>
        //                <prop key="1">1</prop>
        //                <prop key="2">2</prop>
        //                <prop key="3">3</prop>
        //                <prop key="4">4</prop>
        //            </props>
        //        </property>
        //    </bean>
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        ConBean2 conBean2 = (ConBean2) context.getBean("collectionbean");
        System.out.println("list: " + conBean2.getList());
        System.out.println("map: " + conBean2.getMap());
        System.out.println("set: " + conBean2.getSet());
        System.out.println("property: " + conBean2.getProperties());
    }
}
