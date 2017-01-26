/**
 * Created by Usuario on 17/1/2017.
 */
package com.abugauch.bootcamp.Configuration;

import java.sql.Connection;
import java.sql.*;
public class DBConnection {

    private static Connection con;
    public static DBConnection instance;
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password= "cuevana";
    private static final String url="jdbc:mysql://localhost:3306/db_abugauch";

    private DBConnection(){
        try{    Class.forName(driver);
                con = DriverManager.getConnection(url,user,password);
                System.out.println("Connect :)");
            }
        catch(ClassNotFoundException e){
            System.out.println("Error al conectar "+e);
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Se encontro el siguiente error " + e.getMessage());
        }
    }

    public static DBConnection getState(){
            instance = new DBConnection();
            return instance;
    }

    public Connection getCnn(){
        return  con;
    }

    public  void closeCnn(){
        instance = null;
    }
}
