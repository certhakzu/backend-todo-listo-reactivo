package co.com.sofka.model.tarea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
    private String id;
    private String descripcion;
    private Boolean esCompleta;

    public Tarea(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.esCompleta = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return id.equals(tarea.id) && descripcion.equals(tarea.descripcion) && esCompleta.equals(tarea.esCompleta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, esCompleta);
    }
}
