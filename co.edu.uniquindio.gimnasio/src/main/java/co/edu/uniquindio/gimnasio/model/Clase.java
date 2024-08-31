package co.edu.uniquindio.gimnasio.model;

import co.edu.uniquindio.gimnasio.model.enums.TipoClase;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clase {

    private int capacidad;
    private List<Reserva> inscritos;
    private LocalDate fechaInicio, fechaFin;
    private Entrenador entrenador;
    private TipoClase tipoClase;
    private String id, nombre;
    private List<String> horario;
    private boolean disponible;


}
