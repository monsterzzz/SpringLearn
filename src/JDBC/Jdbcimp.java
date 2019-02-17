package JDBC;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class Jdbcimp implements JdbcInterface {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObj;


    @Override
    public void setDataSource(DataSource ds) {
        System.out.println(ds);
        this.dataSource = ds;
        this.jdbcTemplateObj = new JdbcTemplate(dataSource);
    }

    @Override
    public int addStudent(String name, Integer age) {
        try{
            String sql = "INSERT INTO Student (name,age) value (?,?)";
            jdbcTemplateObj.update(sql,name,age);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void deleteStudent(Integer id) {
        try{
            String sql = "DELETE FROM Student WHERE ID = ? ";
            jdbcTemplateObj.update(sql,id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Integer id, Integer age) {
        try{
            String sql = "UPDATE Student Set age = ? Where id = ?";
            jdbcTemplateObj.update(sql,age,id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Student queryStdent(Integer id) {
        Student student = null;
        try{
            String sql = "select * FROM Stdent Where id = ?";
            student = jdbcTemplateObj.queryForObject(sql,new Object[]{id},new StudentSimp());
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> students = null;
        try{
            String sql = "SELECT * FROM Student";
            students = jdbcTemplateObj.query(sql,new StudentSimp());
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
}
