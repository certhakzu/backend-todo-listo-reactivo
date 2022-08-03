package co.com.sofka.mongo.tarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaDocument {
    @Id
    private String id;
    private String idLista;
    private String descripcion;
    private Boolean esCompleta;
}
