package co.edu.uniquindio.gimnasio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Entrenador extends Usuario{

    private String especialidad;

    public Entrenador(String id, String nombre, String especialidad) {
        super(id, nombre);
        this.especialidad = especialidad;
    }
}
