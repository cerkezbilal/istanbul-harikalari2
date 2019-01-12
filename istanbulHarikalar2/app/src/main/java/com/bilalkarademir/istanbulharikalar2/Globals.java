package com.bilalkarademir.istanbulharikalar2;

import android.graphics.Bitmap;

public class Globals {
    private Bitmap secilenResim;
    private static Globals instance;

    private Globals(){


    }

    public void setData(Bitmap secilenResim){

        this.secilenResim = secilenResim;
    }

    public Bitmap getData(){

        return this.secilenResim;
    }

    public static Globals getInstance(){

        if(instance == null){

            instance = new Globals();
        }

        return instance;

    }
}
