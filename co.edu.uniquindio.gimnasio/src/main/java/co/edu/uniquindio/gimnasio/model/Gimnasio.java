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
    public String reservarClase(Cliente cliente, String nombreDeClase, String hora) {
        for(Clase clase: clases){
            if(clase.getNombre().equals(nombreDeClase)){
                if(clase.isDisponible()){
                    for(String horar: clase.getHorario()){
                        if(horar == hora){
                            Sysout("espacio no disponible");
                        }
                    }
                }
            }
        }

        /*
        Clase claseSeleccionada = null;

        // Buscar la clase por ID
        for (Clase clase : clases) {
            if (clase.getId().equals(idClase)) {
                claseSeleccionada = clase;
                break;
            }
        }

        if (claseSeleccionada == null) {
            return "Clase no encontrada.";
        }

        // Verificar disponibilidad de plazas
        if (claseSeleccionada.getCapacidad() <= 0) {
            return "No hay plazas disponibles para esta clase.";
        }

        // Realizar la reserva
        claseSeleccionada.setCapacidad(claseSeleccionada.getCapacidad() - 1);
        if (claseSeleccionada.getCapacidad() == 0) {
            claseSeleccionada.setDisponible(true);
        }

        Reserva nuevaReserva = new Reserva(claseSeleccionada, cliente, LocalDateTime.now());
        reserva.add(nuevaReserva);

        return "Reserva realizada con éxito para la clase " + claseSeleccionada.getNombre() + ".";
         */
    }







}
