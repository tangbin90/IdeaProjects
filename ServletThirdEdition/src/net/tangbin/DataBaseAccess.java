package net.tangbin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by TangBin on 22/12/2016.
 */
public class DataBaseAccess {
    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Test";
            String username="tangbin";
            String password="binbingo";
            conn= DriverManager.getConnection(url, username, password);
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
