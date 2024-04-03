package desafioIntermediario.connection;

import com.sun.source.tree.TryTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/banco";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    public ConnectionFactory(){

    }

    public static Connection getConnection(){

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            return con;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection connection){

        try {
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
