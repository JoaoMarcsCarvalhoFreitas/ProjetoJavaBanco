package desafioIntermediario.dao;

import desafioIntermediario.connection.ConnectionFactory;
import desafioIntermediario.entities.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {


    public void create(Cliente cliente){

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {


            stmt = con.prepareStatement("INSERT INTO Cliente(nome, cpfCliente, telefone) VALUES (?, ?, ?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Já existe esse usuário no banco de dados");
        }finally {

            ConnectionFactory.closeConnection(con);

            }

    }
}
