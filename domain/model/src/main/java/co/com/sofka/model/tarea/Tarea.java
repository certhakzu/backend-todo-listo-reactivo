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
    private String idLista;
    private String descripcion;
    private Boolean esCompleta;

    public Tarea(String id, String idLista, String descripcion) {
        this.id = id; // cuando se cree deberia pasarse idLista+
        this.idLista = idLista;
        this.descripcion = descripcion;
        this.esCompleta = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return id.equals(tarea.id) && idLista.equals(tarea.idLista) && descripcion.equals(tarea.descripcion) && esCompleta.equals(tarea.esCompleta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idLista, descripcion, esCompleta);
    }
}
