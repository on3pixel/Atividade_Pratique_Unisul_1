package main;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static Connection DBConnection = null;
    public static boolean ValidPass;
    public static String result;
    public static void CreateConnection () {
        if (DBConnection == null) {
            try {
                DBConnection = DriverManager.getConnection("jdbc:sqlite:banco.db");
                System.out.println("[+] Banco de dados carregado com sucesso");
                Statement stmt = DBConnection.createStatement();
                String[] SQL = {
                        "CREATE TABLE IF NOT EXISTS events (ID integer PRIMARY KEY, NAME text, DESCRIPTION text, CATEGORY text, DATE text, TIME text, PARTICIPANTS)",
                        "CREATE TABLE IF NOT EXISTS users (ID integer PRIMARY KEY, USER text, PASS text, CITY text,  CEP text, IDADE int)"
                };
                for (String s : SQL) {
                    stmt.execute(s);
                }
            } catch (SQLException e) {
                System.out.println("[+] Falha no banco de dados");
                System.out.println(e.getMessage());
                System.exit(157);
            }
        }
        try {
            File myObj = new File("events.data");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static boolean CheckPass(String user, String pass) {
        String CheckPassSQL = "SELECT * FROM users WHERE USER = ? AND PASS = ?";
        try {
            PreparedStatement stmt = DBConnection.prepareStatement(CheckPassSQL);
            stmt.setString(1, user);
            stmt.setString(2,pass);
            ResultSet rst = stmt.executeQuery();
            if (rst.getString(1) == null) { return false; }
            return true;
        } catch (SQLException e) {
            System.out.println("[!] Falha no login");
        }
        return false;
    }
    public static boolean DestroyConnection () {
        if (DBConnection != null) {
            try {
                DBConnection.close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
}
