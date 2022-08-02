package co.com.sofka.model.tarea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
    private String id;
    private String descripcion;
    private Boolean esCompleta;
}
