package com.oberserve;

import java.util.Observable;

/**
 * Created by zhiqiang.zhao on 2017/1/22.
 */
public class Watched extends Observable {
    private String data = "";

    public String getData() {
        return data;
    }

    public void getData(String data) {

        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }



}
