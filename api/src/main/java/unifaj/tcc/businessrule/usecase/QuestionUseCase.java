package unifaj.tcc.businessrule.usecase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import unifaj.tcc.domain.Question;

import java.util.List;

public interface QuestionUseCase {

    Flux<Question> findQuestionByDifficulty(final String difficulty);

    Flux<Question> findQuestionByOperation(final String operation);

    Mono<Question> saveQuestion(final Question question);

    Flux<Question> findByDifficultyAndOperation(final String difficulty, final String operation);

    Flux<Question> findAll();
}
