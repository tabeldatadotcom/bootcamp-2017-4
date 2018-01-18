package com.maryanto.dimas.jdbc;

import com.maryanto.dimas.jdbc.entity.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            
            String sqlInsert = "insert into departments (department_id, department_name, location_id) values (?, ?, ?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, 1005);
            preparedStatement.setString(2, "Publisher");
            preparedStatement.setInt(3, 1000);
            preparedStatement.executeUpdate();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from departments");

//            untuk mengambil data perbaris
            while (resultSet.next()) {                
                Department dep = new Department(
                        resultSet.getInt("department_id"), 
                        resultSet.getString("department_name"), 
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );
                System.out.println(dep.toString());
            }

            // menutup koneksi ke database
            preparedStatement.close();
            resultSet.close();
            statement.close();
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
