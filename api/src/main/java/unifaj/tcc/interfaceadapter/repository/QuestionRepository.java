package unifaj.tcc.interfaceadapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unifaj.tcc.domain.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByDifficulty(String difficulty);

    List<Question> findByOperation(String operation);

    List<Question> findByDifficultyAndOperation(String difficulty, String operation);
}
