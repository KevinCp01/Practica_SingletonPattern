package SingletonConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static SingletonConnection instance;
    private static Connection conn;
    private String url = "jdbc:mysql:// localhost:3306/javaDB";
    private String user = "test_user";
    private String pass = "1234567";

    private SingletonConnection()throws SQLException{
      
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);            
            System.out.println("Conexion establecida correctamente...");
            System.out.println();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    public static SingletonConnection getInstance()throws SQLException {
        if (instance == null) {
            instance = new SingletonConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new SingletonConnection();
        }
        return instance;
    }


}
