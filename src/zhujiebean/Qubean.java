package zhujiebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Qubean {
    private Dog dog;

    public void dogSay(){
        dog.say();
    }

    public Dog getDog() {
        return dog;
    }

    @Autowired
    @Qualifier("dog3")
    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
