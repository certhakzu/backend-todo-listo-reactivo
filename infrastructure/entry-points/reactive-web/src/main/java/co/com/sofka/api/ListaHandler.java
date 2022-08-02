package co.com.sofka.api;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.usecase.lista.crearlista.CrearListaUseCase;
import co.com.sofka.usecase.lista.eliminarlista.EliminarListaUseCase;
import co.com.sofka.usecase.lista.listarlistas.ListarListasUseCase;
import co.com.sofka.usecase.lista.modificarlista.ModificarListaUseCase;
import co.com.sofka.usecase.lista.modificartareadelista.ModificarTareaDeListaUseCase;
import co.com.sofka.usecase.lista.obtenerlistaporid.ObtenerListaPorIdUseCase;
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
    private  final EliminarListaUseCase eliminarListaUseCase;
    private final ObtenerListaPorIdUseCase obtenerListaPorIdUseCase;
    private final ModificarListaUseCase modificarListaUseCase;



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

    public Mono<ServerResponse> listenDELETEliminarListaUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eliminarListaUseCase.eliminaerLista(id), Lista.class);
    }

    public Mono<ServerResponse> listenGETObtenerListaPorIdUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(obtenerListaPorIdUseCase.obtenerListaPorId(id), Lista.class);
    }

    public Mono<ServerResponse> listenPUTModificarListaUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest
                .bodyToMono(Lista.class)
                .flatMap(lista -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(modificarListaUseCase.modificarLista(id,lista), Lista.class));
    }
}
