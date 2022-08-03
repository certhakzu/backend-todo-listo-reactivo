package co.com.sofka.usecase.lista.eliminartareadelista;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import co.com.sofka.model.tarea.Tarea;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarTareaDeListaUseCase {
    private final ListaRepository listaRepository;

    public Mono<Lista> eliminarTareaDeLista(String idLista, Tarea tarea){
        return listaRepository.findById(idLista)
                .map(lista -> {
                    var tareas = lista.getTareas();
                    tareas.remove(tarea);
                    lista.setTareas(tareas);
                    return lista;
                })
                .flatMap(lista -> listaRepository.update(idLista, lista));
    }
}
