package unifaj.tcc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {

    private String difficulty;
    private String operation;
    private String equation;
    private String answer;
}
