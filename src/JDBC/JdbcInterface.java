package JDBC;

import javax.sql.DataSource;
import java.util.List;

public interface JdbcInterface{
    public void setDataSource(DataSource ds);

    public int addStudent(String name,Integer age);

    public void deleteStudent(Integer id);

    public void updateStudent(Integer id,Integer age);

    public Student queryStdent(Integer id);

    public List<Student> getStudentList();

}


