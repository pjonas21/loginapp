package com.pjonas.loginapp;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConn {
    public Connection databaseLink;

    public Connection getConnection() {

        String databaseName = "users";
        String databaseUser = "YOUR_USER";
        String databasePassword = "YOUR_PASSWORD";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            System.out.println("conexao foi criada");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;

    }
}
