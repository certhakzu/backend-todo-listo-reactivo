package co.com.sofka.api;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.usecase.lista.crearlista.CrearListaUseCase;
import co.com.sofka.usecase.lista.listarlistas.ListarListasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ListaHandler {
    private final CrearListaUseCase crearListaUseCase;
    private final ListarListasUseCase listarListasUseCase;
//private  final UseCase useCase;
//private  final UseCase2 useCase2;


    /*public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }*/

    public Mono<ServerResponse> listenPOSTCrearListaUseCase(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Lista.class)
                .flatMap(lista -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearListaUseCase.crearLista(lista), Lista.class));
    }

    public Mono<ServerResponse> listenGETListarTodasLasListasUseCase(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarListasUseCase.listarTodasLasListas(), Lista.class);
    }
}
