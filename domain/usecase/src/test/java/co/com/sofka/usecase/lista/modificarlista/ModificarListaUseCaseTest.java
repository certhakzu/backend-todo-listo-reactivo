package co.com.sofka.usecase.lista.modificarlista;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import co.com.sofka.model.tarea.Tarea;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


class ModificarListaUseCaseTest {

    @InjectMocks
    ModificarListaUseCase modificarListaUseCase;

    @Mock
    ListaRepository listaRepository;

    @Test
    void modificarLista() {
        List tareas = new ArrayList<>();
        tareas.add(new Tarea("tarea1", false));
        Lista lista = new Lista("1", "prueba1", tareas);

        Mono<Lista> listaMono = Mono.just(lista);
        when(listaRepository.update("1", Mockito.any(Lista.class))).thenReturn(Mono.just(lista.toBuilder().build()));

        StepVerifier.create(modificarListaUseCase.modificarLista("1", Mockito.any(Lista.class)))
                .expectNextMatches(lista1 -> lista1.getId().equals(lista.getId()))
                .expectComplete()
                .verify();
    }
}