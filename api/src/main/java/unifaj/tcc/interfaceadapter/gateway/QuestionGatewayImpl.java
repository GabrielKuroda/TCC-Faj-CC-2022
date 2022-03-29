package unifaj.tcc.interfaceadapter.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import unifaj.tcc.businessrule.gateway.QuestionGateway;
import unifaj.tcc.domain.Question;
import unifaj.tcc.interfaceadapter.repository.QuestionRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionGatewayImpl implements QuestionGateway {

    private final QuestionRepository questionRepository;

    @Override
    public Flux<Question> findByDifficulty(String difficulty) {
        return questionRepository.findByDifficulty(difficulty);
    }

    @Override
    public Flux<Question> findByOperation(String operation) {
        return questionRepository.findByOperation(operation);
    }

    @Override
    public Flux<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Flux<Question> findByDifficultyAndOperation(String difficulty, String operation) {
        return questionRepository.findByDifficultyAndOperation(difficulty, operation);
    }

    @Override
    public Mono<Question> saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}
