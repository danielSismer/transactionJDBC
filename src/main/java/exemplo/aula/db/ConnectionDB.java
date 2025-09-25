package exemplo.aula.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/test_transaction";
    private static final String USER = "root";
    private static final String SENHA = "mysqlPW";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, SENHA);
    }

    public static void main (String [] args ) throws SQLException {
        try{
            Connection conn = ConnectionDB.getConnection();
            if (conn != null ){
                System.out.println("Conexão estabelecida com sucesso!!!");
            } else {
                System.out.println("Falha ao conectar ao banco de dados!!!");
            }
        } catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
