package com.maryanto.dimas.example.oop;

public class Mobil extends Kendaraan{

    private String nama;

    public void setNama(String nama){
        System.out.println(jumlahRoda);
        // tidak bisa di akses karena private
        //  System.out.println(pabrik);
       this.nama = nama ;
    }

    public String nama(){
        return this.nama;
    }

    public static void main(String[] args){
        Mobil honda = new Mobil();
        honda.setNama("Honda civic");

        System.out.println(honda.nama());
    }
}