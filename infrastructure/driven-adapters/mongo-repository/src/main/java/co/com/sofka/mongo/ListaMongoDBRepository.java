package co.com.sofka.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface ListaMongoDBRepository extends ReactiveMongoRepository<ListaDocument, String>, ReactiveQueryByExampleExecutor<ListaDocument> {
}
