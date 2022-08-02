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
            .andRoute(GET("/api/listarlistas"), listaHandler::listenGETListarTodasLasListasUseCase);
            /*.and(route(GET("/api/otherusercase/path"), listaHandler::listenGETOtherUseCase));*/

    }
}
