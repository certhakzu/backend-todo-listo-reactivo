package co.com.sofka.usecase.lista.agregartareaalista;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import co.com.sofka.model.tarea.Tarea;
import co.com.sofka.model.tarea.gateways.TareaRepository;
import co.com.sofka.usecase.tarea.creartarea.CrearTareaUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarTareaAListaUseCase {
    private final ListaRepository listaRepository;
    private final CrearTareaUseCase crearTareaUseCase;

    public Mono<Lista> agregarTareaALista(String idLista, Tarea tarea){

        tarea.setIdLista(idLista);
        crearTareaUseCase.crearTarea(tarea);

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
