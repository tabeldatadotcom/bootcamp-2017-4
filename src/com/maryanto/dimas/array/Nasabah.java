package com.maryanto.dimas.array;

import java.math.BigDecimal;

public class Nasabah{

    private String cif;
    private String namaLengkap;
    private BigDecimal saldo;

    public Nasabah(String cif, String namaLengkap, BigDecimal saldo){
        this.cif = cif;
        this.namaLengkap = namaLengkap;
        this.saldo = saldo;
    }

    public String getCif(){
        return this.cif;
    }

    public String getNamaLengkap(){
        return this.namaLengkap;
    }

    public BigDecimal getSaldo(){
        return this.saldo;
    }

    @Override
    public String toString(){
        return String.format(
            "{ cif: %s, nama: %s, saldo: %s }", 
            cif, namaLengkap, saldo
        );
    }
}