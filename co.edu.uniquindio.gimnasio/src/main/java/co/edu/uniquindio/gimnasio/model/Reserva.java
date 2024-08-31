package co.edu.uniquindio.gimnasio.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class Reserva {
    private LocalDateTime fechaReserva;
    private Cliente cliente;
    private String codigo;

    public Reserva(LocalDateTime fechaReserva, Cliente cliente, String codigo) {
        this.fechaReserva = fechaReserva;
        this.cliente = cliente;
        this.codigo = codigo;
    }
}
