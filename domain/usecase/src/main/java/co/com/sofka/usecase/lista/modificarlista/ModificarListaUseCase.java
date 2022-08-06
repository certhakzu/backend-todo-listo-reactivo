package co.com.sofka.usecase.lista.modificarlista;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ModificarListaUseCase {
    private final ListaRepository listaRepository;

    public Mono<Lista> modificarLista(String id, Lista lista){
        return listaRepository.findById(id)
                .map(lista1 -> {
                    lista1.setTareas(lista.getTareas());
                    lista1.setNombre(lista.getNombre());
                    return lista1;
                })
                .flatMap(lista1 -> listaRepository.update(id, lista1));
    }
}
