package co.com.sofka.model.lista;
import co.com.sofka.model.tarea.Tarea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Lista {
    private String id;
    private String nombre;
    private List<Tarea> tareas;

    public Lista(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.tareas = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista lista = (Lista) o;
        return id.equals(lista.id) && nombre.equals(lista.nombre) && tareas.equals(lista.tareas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tareas);
    }
}
