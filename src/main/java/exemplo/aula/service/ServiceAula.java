package exemplo.aula.service;

import exemplo.aula.dao.AccountDAO;
import exemplo.aula.db.ConnectionDB;
import exemplo.aula.view.TransferInterface;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class ServiceAula {

    public static void exemploAula() throws SQLException{

        int origem = TransferInterface.readOriginAccount();
        int destino = TransferInterface.readDestinationAccount();
        BigDecimal valor = TransferInterface.readAmount();

        try(Connection conn = ConnectionDB.getConnection()){
            conn.setAutoCommit(false);
            try{
                AccountDAO.debit(conn, origem, valor);
                AccountDAO.credit(conn, destino, valor);
                conn.commit();
                System.out.println("Transferência realizada com sucesso!");
            } catch (SQLException e ){
                e.printStackTrace();
                conn.rollback();
                System.out.println("Transferência revertida (rollback).");
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}
