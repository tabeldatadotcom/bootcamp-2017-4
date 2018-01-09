package com.maryanto.dimas.array;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class DaftarNasabah{

    public static void main(String[] args){
        Nasabah dimas = 
            new Nasabah("001", "dimas maryanto", new BigDecimal(10000));
        System.out.println(dimas.toString());

        List<Nasabah> list = new ArrayList<>();
        list.add(dimas);
        list.add(
            new Nasabah("002", "Muhamad Yusuf", new BigDecimal(20000) )
        );
        list.add(
            new Nasabah("003", "Hadi", new BigDecimal(250000) )
        );

        Nasabah indexKe2 = list.get(2);
        System.out.println("index ke 2 adalah "+ indexKe2.toString());

        for(Nasabah n: list){
            System.out.println(n.toString());
        }
    }
}