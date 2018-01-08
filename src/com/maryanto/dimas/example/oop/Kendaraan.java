package com.maryanto.dimas.example.oop;

public class Kendaraan{

    public Integer jumlahRoda = 4;
    private String pabrik;

    public String getNamaPabrik(){
        return this.pabrik;
    }

    public void setNamaPabrik(String pabrik){
        this.pabrik = pabrik;
    }

}