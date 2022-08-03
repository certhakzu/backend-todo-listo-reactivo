package co.com.sofka.usecase.tarea.creartarea;

import co.com.sofka.model.tarea.Tarea;
import co.com.sofka.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearTareaUseCase {
    private final TareaRepository tareaRepository;

    public Mono<Tarea> crearTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }
}
