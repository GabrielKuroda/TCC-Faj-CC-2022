package unifaj.tcc.interfaceadapter.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import unifaj.tcc.businessrule.usecase.QuestionUseCase;
import unifaj.tcc.domain.Question;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionUseCase questionUseCase;

    @GetMapping("/filter/difficulty/{difficulty}")
    public Flux<Question> findQuestionByDifficulty(@PathVariable String difficulty) {
        return questionUseCase.findQuestionByDifficulty(difficulty);
    }

    @GetMapping("/filter/operation/{operation}")
    public Flux<Question> findQuestionByOperation(@PathVariable String operation) {
        return questionUseCase.findQuestionByOperation(operation);
    }

    @GetMapping("/filter/{difficulty}/{operation}")
    public Flux<Question> findByDifficultyAndOperation(@PathVariable String difficulty, @PathVariable String operation) {
        return questionUseCase.findByDifficultyAndOperation(difficulty, operation);
    }

    @GetMapping("")
    public Flux<Question> findAll() {
        return questionUseCase.findAll();
    }

    @PostMapping("/addQuestion")
    public Mono<Question> saveQuestion(@RequestBody Question question) {
        return questionUseCase.saveQuestion(question);
    }
}
