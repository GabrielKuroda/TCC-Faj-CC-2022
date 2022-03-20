package unifaj.tcc.businessrule.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import unifaj.tcc.businessrule.gateway.QuestionGateway;
import unifaj.tcc.domain.Question;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionUseCaseImpl implements QuestionUseCase {

    private final QuestionGateway gateway;

    @Override
    public Flux<Question> findQuestionByDifficulty(String difficulty) {
        return gateway.findByDifficulty(difficulty);
    }

    @Override
    public Flux<Question> findQuestionByOperation(String operation) {
        return gateway.findByOperation(operation);
    }

    @Override
    public Flux<Question> findAll() {
        return gateway.findAll();
    }

    @Override
    public Flux<Question> findByDifficultyAndOperation(String difficulty, String operation) {
        return gateway.findByDifficultyAndOperation(difficulty, operation);
    }

    @Override
    public Mono<Question> saveQuestion(Question question) {
        return gateway.saveQuestion(question);
    }
}
