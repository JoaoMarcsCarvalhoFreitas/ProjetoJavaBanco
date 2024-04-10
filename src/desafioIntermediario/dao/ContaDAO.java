package desafioIntermediario.dao;

import desafioIntermediario.connection.ConnectionFactory;
import desafioIntermediario.entities.Cliente;
import desafioIntermediario.entities.Conta;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    public void createConta(Cliente cliente, String senha, String chave){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO Conta(idDono, saldo, senha, chaveTransferencia) VALUES (?, ?, ?, ?)");

            stmt.setInt(1, cliente.getId());
            stmt.setDouble(2, 0.0);
            stmt.setString(3, senha);
            stmt.setString(4, chave);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Conta inserida com sucesso!!!");


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao criar conta (Dados incorretos" +
                    " ou servidor com problemas)");
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con);
        }

    }

    public List<Conta> readConta(){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        List<Conta> contas = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM Conta");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                Conta c = new Conta(Integer.parseInt(rs.getString("idDono")),
                        Double.parseDouble(rs.getString("saldo")), rs.getString("senha"),
                        rs.getString("chaveTransferencia"));

                contas.add(c);
            }

            return contas;

        }catch (SQLException e){

            e.printStackTrace();
            return null;

        }finally {

            ConnectionFactory.closeConnection(con);

        }
    }


}
