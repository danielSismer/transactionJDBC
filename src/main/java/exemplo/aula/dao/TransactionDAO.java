package exemplo.aula.dao;

import exemplo.aula.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {

    public static void insertUser(User user, Connection conn) throws SQLException {
        String query = "INSERT INTO users (nome, email) VALUES (?, ?)";
        try (
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            int affected = stmt.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Falha ao inserir usuário: nenhuma linha afetada.");
            }
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter ID gerado do usuário.");
                }
            }
            System.out.println("Usuário registrado com sucesso! ID: " + user.getId());
        }
    }

    public static void updateUserEmail(int userId, String novoEmail, Connection conn) throws SQLException {
        String query = "UPDATE users SET email = ? WHERE id = ?";
        try (
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, novoEmail);
            stmt.setInt(2, userId);
            int updated = stmt.executeUpdate();
            if (updated == 0) {
                throw new SQLException("Nenhum usuário atualizado. ID pode não existir: " + userId);
            }
            System.out.println("Email do usuário atualizado com sucesso!");
        }
    }
}