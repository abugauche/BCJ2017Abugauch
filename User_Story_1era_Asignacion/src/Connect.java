/**
 * Created by Usuario on 12/1/2017.
 */
import java.sql.Connection;
import java.sql.*;
public class Connect {
    private static Connection conn;
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password= "cuevana";
    private static final String url="jdbc:mysql://localhost:3306/mydb";

    public void Connect(){
        conn= null;
        try {
            System.out.println("Intento de conexion a la base de datos");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
        }
        catch(SQLException e){
            System.out.println("Error de MySQL");

        }
        catch(ClassNotFoundException e){
            System.out.println("Error al conectar"+e);
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Se encontro el siguiente error " + e.getMessage());
        }

    }

    public Connection getConnect(){
        return conn;
    }
    public void desconnection(){
        conn=null;
        System.out.println("Conexion terminada.");
    }
}
