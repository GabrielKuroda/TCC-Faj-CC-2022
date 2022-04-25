package unifaj.tcc.interfaceadapter.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import unifaj.tcc.businessrule.gateway.QuestionGateway;
import unifaj.tcc.domain.Question;
import unifaj.tcc.interfaceadapter.repository.QuestionRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionGatewayImpl implements QuestionGateway {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findByDifficulty(String difficulty) {
        return questionRepository.findByDifficulty(difficulty);
    }

    @Override
    public List<Question> findByOperation(String operation) {
        return questionRepository.findByOperation(operation);
    }

    @Override
    public Question findByEquation(String equation) {
        return questionRepository.findByEquation(equation);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findByDifficultyAndOperation(String difficulty, String operation) {
        return questionRepository.findByDifficultyAndOperation(difficulty, operation);
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}
