import JDBC.Jdbcimp;
import JDBC.StudentSimp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcMain {
    private static final String xmlName = "jdbcConfig.xml";
    public static void main(String[] args) {
        JdbcTest1();
    }

    public static void JdbcTest1(){
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlName);
        Jdbcimp jdbcimp = (Jdbcimp) context.getBean("mydb");
        jdbcimp.addStudent("monster",30);

    }
    
}
