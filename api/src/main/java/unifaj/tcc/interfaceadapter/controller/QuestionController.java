package unifaj.tcc.interfaceadapter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unifaj.tcc.businessrule.usecase.QuestionUseCase;
import unifaj.tcc.domain.Question;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionUseCase questionUseCase;

    @GetMapping("/filter/difficulty/{difficulty}")
    public List<Question> findQuestionByDifficulty(@PathVariable String difficulty) {
        return questionUseCase.findQuestionByDifficulty(difficulty);
    }

    @GetMapping("/filter/operation/{operation}")
    public List<Question> findQuestionByOperation(@PathVariable String operation) {
        return questionUseCase.findQuestionByOperation(operation);
    }

    @GetMapping("/filter/{difficulty}/{operation}")
    public List<Question> findByDifficultyAndOperation(@PathVariable String difficulty, @PathVariable String operation) {
        return questionUseCase.findByDifficultyAndOperation(difficulty, operation);
    }

    @GetMapping("")
    public List<Question> findAll() {
        return questionUseCase.findAll();
    }

    @PostMapping("/addQuestion")
    public Question saveQuestion(@RequestBody Question question) {

        return questionUseCase.saveQuestion(question);
    }
}
