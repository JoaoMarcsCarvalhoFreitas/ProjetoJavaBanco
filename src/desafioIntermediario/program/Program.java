package desafioIntermediario.program;

import desafioIntermediario.connection.ConnectionFactory;
import desafioIntermediario.dao.ClienteDAO;
import desafioIntermediario.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente = new Cliente("João Marcos", "03720949290", "94991345721");
        Cliente cliente1 = new Cliente("João Marcos", "11122233345", "94991345721");

        ClienteDAO cl = new ClienteDAO();

        // Cria Clientes
        cl.create(cliente1);

        // Faz a leitura dos clientes cadastrados
        clientes = cl.readClientes();

        for (Cliente cliente2: clientes){
            System.out.println(cliente2.toString());
        }

        // Update de telefone Cliente
        cl.updateCliente(cliente1.getCpf(), "94992345678");

        // Deletar o cliente pelo CPF
        cl.deleteCliente(cliente1.getCpf());

    }
}
