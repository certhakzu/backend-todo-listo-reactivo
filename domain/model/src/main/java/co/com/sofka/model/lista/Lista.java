package co.com.sofka.model.lista;
import co.com.sofka.model.tarea.Tarea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Lista {
    private String id;
    private String nombre;
    private List<Tarea> tareas;
}
