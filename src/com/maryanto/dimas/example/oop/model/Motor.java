package com.maryanto.dimas.example.oop.model;

import com.maryanto.dimas.example.oop.Kendaraan;

public class Motor extends Kendaraan{

    public String getNamaPabrik(){
        return "Yamaha";
    }

    public void setNamaPabrik(String pabrik){
        super.setNamaPabrik("kendaraan belum di isi!");
        System.out.println(
            String.format("dari kelas motor:  %s", this.getNamaPabrik())
        );
        System.out.println(
            String.format("dari kelas kendaran: %s", super.getNamaPabrik())
        );
    }

    public static void main(String[] args){
        Motor yamaha = new Motor();
        yamaha.setNamaPabrik(yamaha.getNamaPabrik());
    }

}