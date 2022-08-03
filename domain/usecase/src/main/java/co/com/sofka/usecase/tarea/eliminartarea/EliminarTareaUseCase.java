package co.com.sofka.usecase.tarea.eliminartarea;

import co.com.sofka.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarTareaUseCase {
    private final TareaRepository tareaRepository;

    public Mono<Void> eliminarTarea(String id){
        return tareaRepository.deleteById(id);
    }
}
