package co.edu.uniquindio.gimnasio.model;

import co.edu.uniquindio.gimnasio.model.enums.TipoEntrenamiento;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entrenamiento {

    private int duracion;
    private LocalDateTime fecha;
    private String numeroSesion;
    private TipoEntrenamiento tipoEntrenamiento;
    private int caloriasQuemadas;

}
