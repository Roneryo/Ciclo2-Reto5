package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    private static final String UBICACION_BD = "/home/roner/Downloads/ProyectosConstruccion.db";

    public static Connection getConnection() {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        try {
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
