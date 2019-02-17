package zhujiebean;

public class ByConstructorbean {
    private Dog dog;

    public ByConstructorbean(Dog dog){
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
