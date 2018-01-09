package com.maryanto.dimas.array;

public class PrimitifArray{

    public static void main(String[] args){
        String[] pesertaBootcamp = {
            "Dimas Maryanto",
            "Yusuf",
            "Gian",
            "Ikbal"
        };

        System.out.println(
            String.format(
                "peserta bootcamp index ke 2 adalah %s ",pesertaBootcamp[2]
            )
        );

        for(int i = 0; i < pesertaBootcamp.length; i++){
            System.out.print(pesertaBootcamp[i]+ ", ");
        }
    }
}