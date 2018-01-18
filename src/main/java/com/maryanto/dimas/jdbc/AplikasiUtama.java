package com.maryanto.dimas.jdbc;

import com.maryanto.dimas.jdbc.dao.DepartmentDao;
import com.maryanto.dimas.jdbc.entity.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;

public class AplikasiUtama {

    public static void koneksi() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("hr");
        ds.setPassword("hr");
        ds.setUrl("jdbc:postgresql://localhost:5432/hr");
        ds.setDriverClassName("org.postgresql.Driver");

        try {
            // membuka koneksi ke database
            Connection connection = ds.getConnection();
            System.out.println("berhasil koneksi ke database");
            DepartmentDao dao = new DepartmentDao(connection);
            
//            save nilai department
            dao.save(new Department(2002, "Sistem Analis", 1000, null));
            
//            untuk ambil nilainya
            List<Department> daftarDepartment = dao.findAll();
            for(Department d : daftarDepartment){
                System.out.println(d.toString());
            }
            
            connection.close();
        } catch (SQLException sqle) {
            System.err.printf("tidak dapat koneksi ke databas!");
            sqle.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Halo ini aplikasi maven pertama");

        koneksi();
    }

}
