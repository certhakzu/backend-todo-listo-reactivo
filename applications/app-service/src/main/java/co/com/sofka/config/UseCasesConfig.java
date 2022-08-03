package co.com.sofka.config;

import co.com.sofka.model.tarea.Tarea;
import co.com.sofka.model.tarea.gateways.TareaRepository;
import co.com.sofka.usecase.tarea.creartarea.CrearTareaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
@ComponentScan(basePackages = "co.com.sofka.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public CrearTareaUseCase getCrearTareaUseCase(){
                return new CrearTareaUseCase(new TareaRepository() {
                        @Override
                        public Mono<Tarea> save(Tarea tarea) {
                                return null;
                        }

                        @Override
                        public Mono<Tarea> findById(String id) {
                                return null;
                        }

                        @Override
                        public Flux<Tarea> findAll() {
                                return null;
                        }

                        @Override
                        public Mono<Tarea> update(String id, Tarea tarea) {
                                return null;
                        }

                        @Override
                        public Mono<Void> deleteById(String id) {
                                return null;
                        }
                })
        }
}
