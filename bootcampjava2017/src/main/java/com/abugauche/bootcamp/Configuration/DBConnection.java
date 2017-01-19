/**
 * Created by Usuario on 17/1/2017.
 */
package com.abugauche.bootcamp.Configuration;

import java.sql.Connection;
import java.sql.*;
public class DBConnection {

    private static Connection con=null;

    public static Connection getConnection(){
        try{
            if( con == null ){
                String driver="com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
                String url="jdbc:mysql://localhost:3306/db_abugauch";
                String pwd="cuevana";
                String usr="root";
                Class.forName(driver);
                con = DriverManager.getConnection(url,usr,pwd);
                System.out.println("Connect :)");
            }
        }

        catch(ClassNotFoundException e){
            System.out.println("Error al conectar "+e);
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Se encontro el siguiente error " + e.getMessage());
        }
        return con;
    }
}
