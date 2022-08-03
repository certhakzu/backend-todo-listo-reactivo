package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class ListaRouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(ListaHandler listaHandler) {
    return route(POST("/api/crearlista"), listaHandler::listenPOSTCrearListaUseCase)// espera una Lista en el body
            .andRoute(GET("/api/listarlistas"), listaHandler::listenGETListarTodasLasListasUseCase)
            .andRoute(DELETE("/api/eliminarlista/{id}"), listaHandler::listenDELETEliminarListaUseCase) // espera el id de la lista a eliminar en la url
            .andRoute(GET("/api/obtenerlista/{id}"), listaHandler::listenGETObtenerListaPorIdUseCase)
            .andRoute(PUT("/api/modificarlista/{id}"), listaHandler::listenPUTModificarListaUseCase) // espera el id en la url y la lista en el body
            .andRoute(POST("/api/agregartarea/{id}"), listaHandler::listenPOSTAgregarTareaAListaUseCase) // espera el id de la lista en la url y la tarea a gregar a esta lista en el body
            .andRoute(PUT("/api/eliminartarea/{id}"), listaHandler::listenPUTEliminarTareaDeListaUseCase); // espera el id de la lista en la url y la tarea a eliminar en el body
            /*.and(route(GET("/api/otherusercase/path"), listaHandler::listenGETOtherUseCase));*/

    }
}
