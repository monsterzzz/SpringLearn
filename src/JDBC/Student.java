package JDBC;

public class Student {
    private String name;
    private Integer age;
    private Integer id;

    public Student(String name,Integer age,Integer id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
