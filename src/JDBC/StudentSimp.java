package JDBC;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSimp implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student(resultSet.getString("name"),resultSet.getInt("age"),resultSet.getInt("id"));
        return student;
    }
}