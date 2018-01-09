package com.maryanto.dimas.array;

public class Array2Dimensi{
    public static void main(String[] args){
        Integer[][] values = { {1,2,3}, {2,3,5}, {3,4,5} };

        // menampilkan data pada index ke 0 dan 2
        System.out.println(values[0][2]);

        // menampilkan isi yang ada di array 2 dimention
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(values[i][j]);
            }
            System.out.println();		
        }   

        // output => 123
        // output => 235

        // [i] = 0 : [j] = 0 = 1
        // [i] = 0 : [j] = 1 = 2
        // [i] = 0 : [j] = 2 = 3
        // [i] = 0 : [j] = 3 = x
        // [i] = 1 : [j] = 0 = 2
        // [i] = 1 : [j] = 1 = 3
        // [i] = 1 : [j] = 2 = 5
    }

}