package co.com.sofka.mongo.tarea;

import co.com.sofka.model.tarea.Tarea;
import co.com.sofka.model.tarea.gateways.TareaRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TareaMongoRepositoryAdapter extends AdapterOperations<Tarea, TareaDocument, String, TareaMongoDBRepository>
implements TareaRepository
{

    public TareaMongoRepositoryAdapter(TareaMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Tarea.class));
    }

    @Override
    public Mono<Tarea> update(String id, Tarea tarea) {
        tarea.setId(id);
        return repository.save(new TareaDocument(
                tarea.getId(),
                tarea.getIdLista(),
                tarea.getDescripcion(),
                tarea.getEsCompleta()
        )).flatMap(tareaDocument -> Mono.just(tarea));
    }
}
