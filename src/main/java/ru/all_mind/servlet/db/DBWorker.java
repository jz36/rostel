package ru.all_mind.servlet.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import ru.all_mind.servlet.objects.Human;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class DBWorker {
    private Connection dbConnection = null;

    public DBWorker() {
        dbConnection = ConnectionPool.getInstance().getConnection();
    }

    public JsonArray getData(HttpServletRequest request, Connection connection){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        JsonArray result = new JsonArray();
        ParamsFactory paramsFactory = new ParamsFactory();
        ResultSet rs = null;
        try {
            rs = paramsFactory.getSQLquery(request, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(rs.next()){
                result.add(gson.toJson(new Human(rs.getString("name"), rs.getString("second_name"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Connection getDbConnection(){
        return dbConnection;
    }

    public void closeConnection(){
        try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
