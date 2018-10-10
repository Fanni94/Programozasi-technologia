package konyvtarmanager.controller;

import java.sql.*;

public class AdatbazisManager {
    public Connection dbConnection;
    static final String DB_URL = "jdbc:sqlite:konyvtar.db";
    
    private static AdatbazisManager manager = null;
    
    private AdatbazisManager(){
        try{
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection(DB_URL);
        }
        catch (ClassNotFoundException | SQLException e){
		System.out.println("" + e);
        }
    }
    
    public static AdatbazisManager getInstance(){
        if(manager == null){
                manager = new AdatbazisManager();        
        }
        return manager;
    }
}
