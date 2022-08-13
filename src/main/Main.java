package main;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static main.Database.DBConnection;
import static main.Database.result;
public class Main {
    public static String Menu = "LoginPanel";
    public static void main(String[] args) {
        System.out.println("------------------------");
        System.out.println("[+] Carregando o banco de dados");
        Database.CreateConnection();
        panels.Login.LoginPanel();
    }
}


