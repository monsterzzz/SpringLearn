package funciton;

import DIbeans.ConBean;

public class ConFunciton3 {
    private ConBean conBean;

    public void doThing(){
        conBean.doThing();
    }


    public ConBean getConBean() {
        return conBean;
    }

    public void setConBean(ConBean conBean) {
        this.conBean = conBean;
    }
}
