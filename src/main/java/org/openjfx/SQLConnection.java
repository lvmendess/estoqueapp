package org.openjfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    public static Connection connectDB(){
        Connection conn = null;

        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:estoque_db.db";
            conn = DriverManager.getConnection(url);
            //System.out.println("connected to database");
            return conn;
        }catch(SQLException | ClassNotFoundException e){
            //System.out.println("connection failed");
            e.printStackTrace();
        }
        return null;

    }
}
