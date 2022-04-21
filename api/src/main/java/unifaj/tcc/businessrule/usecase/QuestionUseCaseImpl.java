package unifaj.tcc.businessrule.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifaj.tcc.businessrule.exception.QuestionException;
import unifaj.tcc.businessrule.gateway.QuestionGateway;
import unifaj.tcc.domain.Question;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class QuestionUseCaseImpl implements QuestionUseCase {

    private final QuestionGateway gateway;

    @Override
    public List<Question> findQuestionByDifficulty(String difficulty) {
        return gateway.findByDifficulty(difficulty);
    }

    @Override
    public List<Question> findQuestionByOperation(String operation) {
        return gateway.findByOperation(operation);
    }

    @Override
    public List<Question> findAll() {
        return gateway.findAll();
    }

    @Override
    public List<Question> findByDifficultyAndOperation(String difficulty, String operation) {
        return gateway.findByDifficultyAndOperation(difficulty, operation);
    }

    @Override
    public Question saveQuestion(Question question) {

        Question question1 = gateway.findByEquation(question.getEquation());

        if(!Objects.isNull(question1) && question1.getEquation().equalsIgnoreCase(question.getEquation())) {
            throw new QuestionException();
        }

        return gateway.saveQuestion(question);
    }

    @Override
    public Question findByEquation(String equation) {
        return gateway.findByEquation(equation);
    }
}
