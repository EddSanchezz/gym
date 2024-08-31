package co.edu.uniquindio.gimnasio.model;

import co.edu.uniquindio.gimnasio.model.enums.TipoClase;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
public class Gimnasio {

    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Clase> clases = new ArrayList<>();
    private final ArrayList<Entrenador> entrenadores = new ArrayList<>();

    public void registroEntrenador(String id, String nombre, String especialidad) throws Exception{

        if (id == null || nombre == null || especialidad == null){
            throw new Exception("no puede haber campos vacios");
        }

        Entrenador entrenador = new Entrenador(id, nombre, especialidad);
        entrenadores.add(entrenador);
    }

    public void registroCliente(String id, String nombre, String direccion, String telefono, String correo, String contrasena) throws Exception{

        if (id.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || contrasena.isEmpty()){
            throw new Exception("no puede haber campos vacios");
        }

        Cliente cliente = new Cliente(id, nombre, direccion, telefono, correo, contrasena);
        clientes.add(cliente);
        System.out.println(cliente.getNombre());
    }

    public void actualizarCliente(String id, String nombre, String direccion, String telefono, String correo, String contrasena ) throws Exception {

        Cliente cliente = obtenerUsuario(id);
        if (cliente != null){
            cliente.setNombre(nombre);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);
            cliente.setContrasena(contrasena);

        }else {
            throw new Exception("el usuario no existe");
        }


    }


    public void eliminarUsuario(String id) throws Exception{
        Cliente cliente = obtenerUsuario(id);
        if (cliente != null){
            clientes.remove(cliente);
        }else {
            throw new  Exception("El cliente no existe");
        }
    }

    public Cliente obtenerUsuario(String id){
        for (Cliente cliente : clientes){
            if (cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    } 

    //buscar clases dependiendo del entrenador
    public ArrayList<Clase> buscarPorEntrenador(String entrenador){

        ArrayList<Clase> clasesPorEntrenador = new ArrayList<Clase>();
        for(Clase clase: clases){
            if(clase.getEntrenador().equals(entrenador)){
                clasesPorEntrenador.add(clase);
            }
        }
        return clasesPorEntrenador;
    }

    //buscar clase dependiendo del horario
    public ArrayList<Clase> buscarPorHorario(String horario){
        ArrayList<Clase> clasesPorHorario = new ArrayList<Clase>();
        //para evitar error ingresar el formato correcto (DD/MM/AA)

        for(Clase clase: clases){
            if(clase.getHorario().equals(horario)){
                clasesPorHorario.add(clase);
            }
        }

        return clasesPorHorario;
    }

    //buscar clase dependiendo del tipo de clase
    public ArrayList<Clase> buscarPorTipo(TipoClase tipo) {
        ArrayList<Clase> clasesPorTipo = new ArrayList<Clase>();

        for (Clase clase : clases) {
            if (clase.getTipoClase() == tipo) {
                clasesPorTipo.add(clase);
            }
        }

        return clasesPorTipo;
    }

    // Método para reservar una clase
    public void reservarClase(Cliente cliente, String nombreDeClase, String hora, Reserva reserva) {
        for(Clase clase: clases){
            if(clase.getNombre().equals(nombreDeClase)){
                if(clase.isDisponible()){
                    for(String horar: clase.getHorario()){
                        if(horar == hora){
                            System.out.print("horario no disponible");
                        }else{
                            if(clase.getCapacidad()<=0){
                                clase.setDisponible(false);
                                System.out.print("reservas no disponibles");
                            }else{
                                clase.addHorario(hora);
                                clase.setCapacidad(clase.getCapacidad()-1);
                                clase.addInscritos(reserva);
                            }
                        }
                    }
                }else{
                    System.out.print("clase no disponible");
                }
                break;
            }
        }

    }

    public void cancelarClase(String nombreDeClase, Reserva reserva) {
        for (Clase clase : clases) {
            if (clase.getNombre().equals(nombreDeClase)) {
                List<Reserva> inscritos = clase.getInscritos();
                for (Reserva reserv : inscritos) {
                    if (reserv.getCodigo().equals(reserva.getCodigo())) {
                        clase.getInscritos().remove(reserv);
                        
                        clase.setCapacidad(clase.getCapacidad() + 1);
                        
                        if (!clase.isDisponible() && clase.getCapacidad() > 0) {
                            clase.setDisponible(true);
                        }
                        System.out.println("reserva eliminada");
                        return;
                    }
                }
            }
        }
    }
    
    public void agregarEntrenamiento(Cliente cliente, Entrenamiento entrenamiento){
        for(Cliente client: clientes){
            if(client.getNombre().equals(cliente.getNombre())){
                client.addEntrenamientos(entrenamiento);
                System.out.println("entrenamiento agregado correctamente");
            }
        }
    }
    

    public void consultarEntrenamientos(Cliente cliente){
        for(Cliente client: clientes){
            if(client.getNombre().equals(cliente.getNombre())){
                System.out.println("el cliente "+ client.getNombre() + "ha hecho los siguientes ejercicios: " );
                for(Entrenamiento entren: client.getEntrenamientos()){
                    System.out.println(entren.getTipoEntrenamiento());
                }
            }
        }
    }

}
