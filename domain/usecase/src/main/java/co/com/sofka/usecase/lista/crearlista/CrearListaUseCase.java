package co.com.sofka.usecase.lista.crearlista;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearListaUseCase {

    private final ListaRepository listaRepository;

    public Mono<Lista> crearLista(Lista lista){
        return listaRepository.save(lista);
    }
}
