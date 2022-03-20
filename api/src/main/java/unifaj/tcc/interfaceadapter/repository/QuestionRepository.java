package unifaj.tcc.interfaceadapter.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import unifaj.tcc.domain.Question;


@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
    Flux<Question> findByDifficulty(String difficulty);

    Flux<Question> findByOperation(String operation);

    Flux<Question> findByDifficultyAndOperation(String difficulty, String operation);

    Mono<Question> save(Question question);
}
