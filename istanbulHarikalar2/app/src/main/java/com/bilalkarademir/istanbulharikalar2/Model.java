package com.bilalkarademir.istanbulharikalar2;

public class Model {

    private String baslik;
    private String icerik;
    private int resimId;

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public int getResimId() {
        return resimId;
    }

    public void setResimId(int resimId) {
        this.resimId = resimId;
    }

    public Model(String baslik, String icerik, int resimId) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.resimId = resimId;


    }
}
