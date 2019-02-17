package funciton;

import DIbeans.ConBean;

public class ConFunciton {
    private ConBean conBean;
    public ConFunciton(ConBean conBean){
        System.out.println("insert...");
        this.conBean = conBean;
    }

    public void doThing(){
        conBean.doThing();
    }



}
