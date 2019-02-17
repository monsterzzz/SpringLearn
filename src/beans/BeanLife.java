package beans;

interface Life{
    void init();
    void destroy();

}

public class BeanLife implements Life{

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void init() {
        System.out.println("init over!");
    }

    @Override
    public void destroy() {
        System.out.println("destory over!");
    }
}
