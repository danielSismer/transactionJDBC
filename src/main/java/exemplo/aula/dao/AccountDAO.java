package exemplo.aula.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

    public static void debit(Connection conn, int accountId, BigDecimal amount) throws SQLException {
        String sql = "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?";
        try (
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setBigDecimal(1, amount);
            ps.setInt(2, accountId);
            ps.setBigDecimal(3, amount);
            int updated = ps.executeUpdate();
            if (updated == 0) {
                throw new SQLException("Saldo insuficiente ou conta inexistente para débito. ID=" + accountId);
            }
        }
    }

    public static void credit(Connection conn, int accountId, BigDecimal amount) throws SQLException {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setBigDecimal(1, amount);
            ps.setInt(2, accountId);
            int updated = ps.executeUpdate();
            if (updated == 0) {
                throw new SQLException("Conta de crédito inexistente. ID=" + accountId);
            }
        }
    }
}


