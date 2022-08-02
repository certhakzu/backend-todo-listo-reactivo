package co.com.sofka.usecase.lista.eliminarlista;

import co.com.sofka.model.lista.gateways.ListaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarListaUseCase {
    private final ListaRepository listaRepository;

    public Mono<Void> eliminaerLista(String id){
        return listaRepository.deleteById(id);
    }
}
