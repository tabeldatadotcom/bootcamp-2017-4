package com.maryanto.dimas.array;

import java.util.Map;
import java.util.HashMap;

public class ArrayFwMap{
    
    public static void main(String[] args){
        Map berkas = new HashMap();
        berkas.put("laporan2017", "asldkfjasdljfksdjf");
        berkas.put("laporan2018", "laksdjfklasdlfkjsdakfj");

        System.out.println(berkas.get("laporan2018"));

        berkas.forEach( (kunci,nilai) -> {
            System.out.println(
                String.format(
                    "kata kunci %s dan nilainya adalah %s",
                    kunci, nilai
                )
            );
        });
    }
}