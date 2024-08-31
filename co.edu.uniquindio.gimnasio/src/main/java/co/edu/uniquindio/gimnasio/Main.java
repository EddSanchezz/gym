package co.edu.uniquindio.gimnasio;

import co.edu.uniquindio.gimnasio.model.Cliente;
import co.edu.uniquindio.gimnasio.model.Gimnasio;

public class Main {
    public static void main(String[] args) throws Exception {
        Gimnasio gimnasio = new Gimnasio();

        gimnasio.registroCliente("123456", "Nicolás", "circasia calle 4", "1231312", "nicolas@gmail.com", "nico123");

        Cliente cliente = new Cliente("123456", "Nicolás", "circasia calle 4", "1231312", "nicolas@gmail.com", "nico123");
        gimnasio.consultarEntrenamientos(cliente);
        
    }
}


