package ru.all_mind.servlet.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

class ConnectionPool {
    private static ConnectionPool connectionPool = null;
    private ConnectionPool(){}

   static ConnectionPool getInstance(){
        if (connectionPool == null){
            return new ConnectionPool();
        }
        else{
            return connectionPool;
        }
   }
   Connection getConnection(){
       Context ctx;
       Connection c = null;

       try{
           ctx = new InitialContext();
           DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbpool");
           c = dataSource.getConnection();
       } catch (NamingException e){
           e.printStackTrace();
       } catch (SQLException e){
           e.printStackTrace();
       }

       return c;
   }
}
