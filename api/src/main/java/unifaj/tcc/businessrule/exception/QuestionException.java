package unifaj.tcc.businessrule.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import unifaj.tcc.businessrule.exception.entities.http.gatewayError.QuestionError;

@AllArgsConstructor
@NoArgsConstructor
public class QuestionException extends RuntimeException{

    public QuestionError questionError;

}
