package exemplo.aula.service;

import exemplo.aula.dao.TransactionDAO;
import exemplo.aula.db.ConnectionDB;
import exemplo.aula.model.User;
import exemplo.aula.view.UserInterface;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceAula {

    public static void exemploAula() throws SQLException{

        var user = UserInterface.registerUser();
        String email = UserInterface.updateUser();
        try(Connection conn = ConnectionDB.getConnection()){
            conn.setAutoCommit(false);
            try{
                TransactionDAO.insertUser(user, conn);
                TransactionDAO.updateUser(user, conn);
                conn.commit();
            } catch (SQLException e ){
                e.printStackTrace();
                conn.rollback();
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}
