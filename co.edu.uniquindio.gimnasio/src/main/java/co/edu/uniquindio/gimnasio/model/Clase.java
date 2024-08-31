package co.edu.uniquindio.gimnasio.model;

import java.time.LocalDate;
import java.util.List;

import co.edu.uniquindio.gimnasio.model.enums.TipoClase;

public class Clase {

    private int capacidad;
    private List<Reserva> inscritos;
    private LocalDate fechaInicio, fechaFin;
    private Entrenador entrenador;
    private TipoClase tipoClase;
    private String id, nombre;
    private List<String> horario;
    private boolean disponible;

    // Constructor
    public Clase(int capacidad, List<Reserva> inscritos, LocalDate fechaInicio, LocalDate fechaFin, 
                 Entrenador entrenador, TipoClase tipoClase, String id, String nombre, 
                 List<String> horario, boolean disponible) {
        this.capacidad = capacidad;
        this.inscritos = inscritos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.entrenador = entrenador;
        this.tipoClase = tipoClase;
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.disponible = disponible;
    }

    // Getters y Setters

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Reserva> getInscritos() {
        return inscritos;
    }

    public void addInscritos(Reserva reserva) {
        this.inscritos.add(reserva);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHorario() {
        return horario;
    }

    public void addHorario(String horario) {
        this.horario.add(horario);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


}
