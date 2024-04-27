package org.openjfx;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQLCommand {
    public void command(String sqlString){
        Connection conn = null;
        PreparedStatement p = null;

        conn = SQLConnection.connectDB();

        try{
            String sql = sqlString;
            p = conn.prepareStatement(sql);
            p.execute();
            //System.out.println("Todas as alterações foram salvas.");
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
