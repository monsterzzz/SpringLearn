package zhujiebean;

import org.springframework.beans.factory.annotation.Required;

public class Requiredbean {
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }
    @Required
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
