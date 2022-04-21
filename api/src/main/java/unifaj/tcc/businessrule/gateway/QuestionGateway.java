package unifaj.tcc.businessrule.gateway;

import unifaj.tcc.domain.Question;

import java.util.List;

public interface QuestionGateway {
    List<Question> findByDifficulty(final String difficulty);

    List<Question> findByOperation(final String operation);

    Question findByEquation(final String equation);

    List<Question> findAll();

    List<Question> findByDifficultyAndOperation(final String difficulty, final String operation);

    Question saveQuestion(final Question question);
}
