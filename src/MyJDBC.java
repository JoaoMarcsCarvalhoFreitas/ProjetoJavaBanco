import java.sql.*;


public class MyJDBC {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbloja",
                    "root",
                    "root");

            connection.close();



            Statement statement = connection.createStatement();

            //System.out.println("Conexão bem sucedida");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUTO");

            while (resultSet.next()){
                System.out.println(resultSet.getString("descricao"));
                System.out.println(resultSet.getString("id"));
            }

        }catch (SQLException e){

            System.out.println(e.getMessage());
        }

    }

}
