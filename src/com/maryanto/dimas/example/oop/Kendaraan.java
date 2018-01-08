package com.maryanto.dimas.example.oop;

public class Kendaraan{

    public Kendaraan(Integer jumlahRoda){
        this.jumlahRoda = jumlahRoda;
    }

    private Integer jumlahRoda = 4;
    private String pabrik;

    public Integer getJumlahRoda(){
        return this.jumlahRoda;
    }

    public void setJumlahRoda(Integer x){
        this.jumlahRoda = x;
    }

    public String getNamaPabrik(){
        return this.pabrik;
    }

    public void setNamaPabrik(String pabrik){
        this.pabrik = pabrik;
    }

}