package co.com.sofka.model.tarea.gateways;

import co.com.sofka.model.tarea.Tarea;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TareaRepository {

    Mono<Tarea> save(Tarea tarea);
    Mono<Tarea> findById(String id);
    Flux<Tarea> findAll();
    Mono<Tarea> update(String id, Tarea tarea);
    Mono<Void> deleteById(String id);
}