package unifaj.tcc.businessrule.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifaj.tcc.businessrule.gateway.QuestionGateway;
import unifaj.tcc.domain.Question;

import java.util.List;

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
    public Question saveQuestion(Question question) {
        return gateway.saveQuestion(question);
    }
}
