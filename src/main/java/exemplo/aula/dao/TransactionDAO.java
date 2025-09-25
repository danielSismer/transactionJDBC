package exemplo.aula.dao;

import exemplo.aula.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {

    public static void insertUser(User user, Connection conn) throws SQLException {
        String query = "INSERT INTO user (nome, email, status) VALUES (?, ?, ?)";
        try(
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            System.out.println("Usuário registrado com sucesso!!!");
        }
    }

    public static void updateUser(User user, Connection conn) throws SQLException{
        String query = "UPDATE user SET status = ? WHERE id  ?";
        try(
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso!!!");
        }
    }
}