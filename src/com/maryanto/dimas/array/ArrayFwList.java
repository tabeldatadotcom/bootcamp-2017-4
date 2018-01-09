package com.maryanto.dimas.array;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class ArrayFwList{
    
    public static void main(String[] args){
        List<Integer> values = new ArrayList();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(3);
        values.add(3);

        for(int i = 0; i < values.size() ; i++)
            System.out.println(values.get(i));

    }
}