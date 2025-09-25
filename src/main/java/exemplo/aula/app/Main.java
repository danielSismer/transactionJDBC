package exemplo.aula.app;

import exemplo.aula.dao.TransactionDAO;
import exemplo.aula.db.ConnectionDB;
import exemplo.aula.service.ServiceAula;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main (String [] args ) throws SQLException {
        ServiceAula.exemploAula();
    }
}
