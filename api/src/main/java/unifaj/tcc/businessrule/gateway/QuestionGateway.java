package unifaj.tcc.businessrule.gateway;

import unifaj.tcc.domain.Question;

import java.util.List;

public interface QuestionGateway {
    List<Question> findByDifficulty(final String difficulty);

    List<Question> findByOperation(final String operation);

    List<Question> findAll();

    Question saveQuestion(final Question question);
}
