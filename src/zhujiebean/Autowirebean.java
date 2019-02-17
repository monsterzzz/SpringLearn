package zhujiebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Autowirebean {

    private Dog dog;

    @Autowired
    public Autowirebean(Dog dog){
        System.out.println("now constructor insert");
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }


    public void setDog(Dog dog) {
        System.out.println("now insert");
        this.dog = dog;
    }

    public void dogSay(){
        dog.say();
    }
}
