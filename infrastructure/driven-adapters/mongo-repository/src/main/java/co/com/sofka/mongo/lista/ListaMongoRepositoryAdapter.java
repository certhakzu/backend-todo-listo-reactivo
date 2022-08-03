package co.com.sofka.mongo.lista;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ListaMongoRepositoryAdapter extends AdapterOperations<Lista, ListaDocument, String, ListaMongoDBRepository>
implements ListaRepository
{

    public ListaMongoRepositoryAdapter(ListaMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Lista.class));
    }

    @Override
    public Mono<Lista> update(String id, Lista lista) {
        lista.setId(id);
        return repository.save(new ListaDocument(
                lista.getId(),
                lista.getNombre(),
                lista.getTareas()
        )).flatMap(listaDocument -> Mono.just(lista));
    }
}
