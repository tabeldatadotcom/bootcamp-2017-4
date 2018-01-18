package com.maryanto.dimas.jdbc;

import com.maryanto.dimas.jdbc.dao.DepartmentDao;
import com.maryanto.dimas.jdbc.entity.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;

public class AplikasiUtama {

    public static void koneksi() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("hr");
        ds.setPassword("hr");
        ds.setUrl("jdbc:postgresql://localhost:5432/hr");
        ds.setDriverClassName("org.postgresql.Driver");

        Connection connection = null;

        try {
            // membuka koneksi ke database
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            System.out.println("berhasil koneksi ke database");
            DepartmentDao dao = new DepartmentDao(connection);

//            save nilai department
            Department departmentBaru = dao.save(new Department(null, "Sistem Analis", 1000, null));
            System.out.println(departmentBaru.toString());
            
            dao.save(new Department(null, "Sistem Analis", 1000, null));
            
            dao.delete(3003);
            

//            untuk ambil nilainya
            List<Department> daftarDepartment = dao.findAll();
            for (Department d : daftarDepartment) {
                System.out.println(d.toString());
            }
            connection.commit();
            connection.close();
        } catch (SQLException sqle) {
            System.err.printf("tidak dapat koneksi ke databas!");
            sqle.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Halo ini aplikasi maven pertama");

        koneksi();
    }

}
