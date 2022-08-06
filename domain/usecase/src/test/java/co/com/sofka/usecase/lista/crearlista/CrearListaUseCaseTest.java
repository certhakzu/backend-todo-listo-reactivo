package co.com.sofka.usecase.lista.crearlista;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import co.com.sofka.model.tarea.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CrearListaUseCaseTest {

    @InjectMocks
    CrearListaUseCase crearListaUseCase;

    @Mock
    ListaRepository listaRepository;

    @Test
    void crearLista() {
        // Arrange
        List tareas = new ArrayList<>();
        tareas.add(new Tarea("tarea1", false));
        Lista lista = new Lista("1", "prueba1", tareas);

        Mono<Lista> listaMono = Mono.just(lista);
        when(listaRepository.save(lista)).thenReturn(listaMono);

        // Act
        StepVerifier.create(crearListaUseCase.crearLista(lista))
                .expectNextMatches(lista1 -> lista1.getId().equals("1") && lista1.getNombre().equals("prueba1"))
                .expectComplete()
                .verify();

        // Assert
    }
}