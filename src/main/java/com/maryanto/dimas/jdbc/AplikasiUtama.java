package com.maryanto.dimas.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class AplikasiUtama {
    
    public static void koneksi(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("hr");
        ds.setPassword("hr");
        ds.setUrl("jdbc:postgresql://localhost:5432/hr");
        ds.setDriverClassName("org.postgresql.Driver");
        
        try{
            // membuka koneksi ke database
            Connection connection = ds.getConnection();
            System.out.println("berhasil koneksi ke database");
            
            // menutup koneksi ke database
            connection.close();
        }catch(SQLException sqle){
            System.err.printf("tidak dapat koneksi ke databas!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Halo ini aplikasi maven pertama");
        
        koneksi();
    }

}
