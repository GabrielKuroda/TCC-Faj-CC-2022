package unifaj.tcc.businessrule.usecase;

import unifaj.tcc.domain.Question;

import java.util.List;

public interface QuestionUseCase {

    List<Question> findQuestionByDifficulty(final String difficulty);

    List<Question> findQuestionByOperation(final String operation);

    Question saveQuestion(final Question question);

    List<Question> findByDifficultyAndOperation(final String difficulty, final String operation);

    List<Question> findAll();
}
