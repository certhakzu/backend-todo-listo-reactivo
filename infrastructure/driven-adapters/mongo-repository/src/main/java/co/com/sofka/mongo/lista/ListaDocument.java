package co.com.sofka.mongo.lista;

import co.com.sofka.model.tarea.Tarea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaDocument {
    @Id
    private String id;
    private String nombre;
    private List<Tarea> tareas;
}
