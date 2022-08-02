package co.com.sofka.usecase.lista.listarlistas;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarListasUseCase {
    private final ListaRepository listaRepository;

    public Flux<Lista> listarTodasLasListas(){
        return listaRepository.findAll();
    }
}
