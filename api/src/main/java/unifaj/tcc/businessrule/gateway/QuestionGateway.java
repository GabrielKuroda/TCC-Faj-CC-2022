package unifaj.tcc.businessrule.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import unifaj.tcc.domain.Question;

import java.util.List;

public interface QuestionGateway {
    Flux<Question> findByDifficulty(final String difficulty);

    Flux<Question> findByOperation(final String operation);

    Flux<Question> findAll();

    Flux<Question> findByDifficultyAndOperation(final String difficulty, final String operation);

    Mono<Question> saveQuestion(final Question question);
}
