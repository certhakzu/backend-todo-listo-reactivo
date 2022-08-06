package co.com.sofka.usecase.lista.agregartareaalista;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import co.com.sofka.model.tarea.Tarea;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarTareaAListaUseCase {
    private final ListaRepository listaRepository;

    public Mono<Lista> agregarTareaALista(String idLista, Tarea tarea){
        return listaRepository.findById(idLista)
                .map(lista -> {
                    var tareas = lista.getTareas();
                    tareas.add(tarea);
                    lista.setTareas(tareas);
                    return lista;
                })
                .flatMap(listaRepository::save);
    }
}
