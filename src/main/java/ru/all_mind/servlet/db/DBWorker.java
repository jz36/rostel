package ru.all_mind.servlet.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBWorker {
    private Connection dbConnection = null;
    private String dbUser = "jz36";
    private String dbPassword = "12345";
    private String dbCharset = "utf8";
    private final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/rostel";
    private static DBWorker dbWorker;

    private DBWorker(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Properties properties = new Properties();
        properties.setProperty("user", dbUser);
        properties.setProperty("password", dbPassword);
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", dbCharset);
        try{
            dbConnection = DriverManager.getConnection(DB_CONNECTION, properties);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static DBWorker getInstance(){
        if(dbWorker == null){
            dbWorker = new DBWorker();
        }
        return dbWorker;
    }

    public ArrayList<String> getData(String sql){
        ArrayList<String> result = new ArrayList<String>();
        String query = sql;
        ResultSet rs = null;
        try {
            Statement statement = dbConnection.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                result.add(rs.getString("name") + " " + rs.getString("second_name") + ';');
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
