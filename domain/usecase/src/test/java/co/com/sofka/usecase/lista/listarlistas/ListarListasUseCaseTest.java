package co.com.sofka.usecase.lista.listarlistas;

import co.com.sofka.model.lista.Lista;
import co.com.sofka.model.lista.gateways.ListaRepository;
import co.com.sofka.model.tarea.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ListarListasUseCaseTest {

    @InjectMocks
    ListarListasUseCase listarListasUseCase;

    @Mock
    ListaRepository listaRepository;

    @Test
    void listarTodasLasListas() {
        var tarea1 = new Tarea("descripcion1", false);
        var tarea2 = new Tarea("descripcion2", false);
        var tareas1 = new ArrayList<Tarea>();
        tareas1.add(tarea1);
        tareas1.add(tarea2);
        var lista1 = new Lista("1", "lista1", tareas1);

        var tarea3 = new Tarea("descripcion3", false);
        var tarea4 = new Tarea("descripcion4", false);
        var tareas2 = new ArrayList<Tarea>();
        tareas2.add(tarea3);
        tareas2.add(tarea4);
        var lista2 = new Lista("2", "lista2", tareas2);

        Flux<Lista> listaFlux = Flux.fromIterable(List.of(lista1, lista2));
        when(listaRepository.findAll()).thenReturn(listaFlux);

        StepVerifier.create(listarListasUseCase.listarTodasLasListas())
                .expectNextMatches(lista -> lista.getId().equals("1"))
                .expectNextMatches(lista -> lista.getId().equals("2"))
                .expectComplete()
                .verify();
    }
}