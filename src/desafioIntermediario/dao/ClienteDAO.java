package desafioIntermediario.dao;

import desafioIntermediario.connection.ConnectionFactory;
import desafioIntermediario.entities.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Cliente> readClientes(){

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM Cliente");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                clientes.add(new Cliente(rs.getString("nome"), rs.getString("cpfCliente"),
                        rs.getString("telefone")));
            }


        }catch (SQLException e){

            e.printStackTrace();

        }finally {

            ConnectionFactory.closeConnection(con);
            return clientes;
        }

    }
}
