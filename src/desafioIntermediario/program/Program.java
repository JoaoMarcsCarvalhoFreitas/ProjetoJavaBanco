package desafioIntermediario.program;

import desafioIntermediario.connection.ConnectionFactory;
import desafioIntermediario.dao.ClienteDAO;
import desafioIntermediario.entities.Cliente;

public class Program {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Cliente cliente = new Cliente("João Marcos", "03720949290", "94991345721");
        Cliente cliente1 = new Cliente("João Marcos", "11122233345", "94991345721");

        ClienteDAO cl = new ClienteDAO();

        cl.create(cliente1);

    }
}
