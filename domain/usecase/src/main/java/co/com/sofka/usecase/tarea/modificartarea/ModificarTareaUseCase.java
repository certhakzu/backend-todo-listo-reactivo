package co.com.sofka.usecase.tarea.modificartarea;

import co.com.sofka.model.tarea.Tarea;
import co.com.sofka.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ModificarTareaUseCase {
    private final TareaRepository tareaRepository;

    public Mono<Tarea> modificarTarea(String id, Tarea tarea){
        //return tareaRepository.update(id, tarea);
        return tareaRepository.findById(id)
                .map(tarea1 -> {
                    tarea1.setIdLista(tarea.getIdLista());
                    tarea1.setDescripcion(tarea.getDescripcion());
                    tarea1.setEsCompleta(tarea.getEsCompleta());
                    return tarea1;
                })
                .flatMap(tarea1 -> tareaRepository.update(id, tarea));
    }
}
