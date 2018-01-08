package com.maryanto.dimas.example.oop;

public class Mobil extends Kendaraan{

    public Mobil(){
        super(4);
        System.out.println("ini contruktur di pangil ketika di inisialiasi");
    }

    public Mobil(String nama){
        super(5);
        this.nama = nama;
        System.out.println(
            String.format("variable nama berisi %s", this.nama)
        );
    }

    private String nama;

    public void setNama(String nama){
        System.out.println(super.getJumlahRoda());
        // tidak bisa di akses karena private
        //  System.out.println(pabrik);
       this.nama = nama ;
    }

    // @Overload
    public String getNamaPabrik(){
        return super.getNamaPabrik();
    }

    public void setNama(){
        System.out.println(super.getJumlahRoda());
        // tidak bisa di akses karena private
        //  System.out.println(pabrik);
       this.nama = "Mitshubitsi" ;
    }

    public String nama(){
        return this.nama;
    }

    public static void main(String[] args){
        Mobil honda = new Mobil("Lamborgini");
        honda.setNama();
        System.out.println(honda.nama());
        honda.setNama("Honda Civic");
        System.out.println(honda.nama());

        honda.setNamaPabrik("Astra Honda");
        System.out.println(
            String.format("nama pabrik %s", honda.getNamaPabrik())
        );
    }
}