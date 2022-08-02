package co.com.sofka.usecase.lista.obtenerlistaporid;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ObtenerListaPorIdUseCase {
    private final ListaRepository listaRepository;

    public Mono<Lista> obtenerListaPorId(String id){
        return listaRepository.findById(id);
    }
}
