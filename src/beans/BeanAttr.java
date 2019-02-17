package beans;

public class BeanAttr {
    private String msg;

    public BeanAttr() {
        System.out.println("Using class : " + getClass() );
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
