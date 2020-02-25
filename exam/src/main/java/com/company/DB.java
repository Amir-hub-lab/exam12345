package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DB {
        private final static String url = "jdbc:postgresql://localhost:5432/";
        private final static String user = "postgres";
        private final static String password = "1q2w3easd";
        public static Connection connect() {
            Connection conn = null;
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected successfully");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            return conn;
        }
    }