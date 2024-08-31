package co.edu.uniquindio.gimnasio.model;


public class Reserva {
    private String fechaReserva;
    private Cliente cliente;
    private String codigo;

    public Reserva(String fechaReserva, Cliente cliente, String codigo) {
        this.fechaReserva = fechaReserva;
        this.cliente = cliente;
        this.codigo = codigo;
    }

    /**
     * @return String return the fechaReserva
     */
    public String getFechaReserva() {
        return fechaReserva;
    }

    /**
     * @param fechaReserva the fechaReserva to set
     */
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * @return Cliente return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return String return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
