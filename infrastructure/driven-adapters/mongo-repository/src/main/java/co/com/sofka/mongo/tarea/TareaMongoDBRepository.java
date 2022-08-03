package co.com.sofka.mongo.tarea;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface TareaMongoDBRepository extends ReactiveMongoRepository<TareaDocument, String>, ReactiveQueryByExampleExecutor<TareaDocument> {
}
