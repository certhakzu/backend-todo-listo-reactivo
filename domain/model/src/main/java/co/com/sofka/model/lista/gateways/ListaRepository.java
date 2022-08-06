package co.com.sofka.model.lista.gateways;

import co.com.sofka.model.lista.Lista;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ListaRepository {

    Mono<Lista> save(Lista lista);
    Mono<Lista> findById(String id);
    Flux<Lista> findAll();
    Mono<Lista> update(String id, Lista lista);
    Mono<Void> deleteById(String id);
}
