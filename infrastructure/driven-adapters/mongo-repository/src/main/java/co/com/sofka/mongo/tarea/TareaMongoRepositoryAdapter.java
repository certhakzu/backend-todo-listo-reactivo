package co.com.sofka.mongo.tarea;

import co.com.sofka.model.tarea.Tarea;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TareaMongoRepositoryAdapter extends AdapterOperations<Tarea, TareaDocument, String, TareaMongoDBRepository>
// implements ModelRepository from domain
{

    public TareaMongoRepositoryAdapter(TareaMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Tarea.class));
    }
}
