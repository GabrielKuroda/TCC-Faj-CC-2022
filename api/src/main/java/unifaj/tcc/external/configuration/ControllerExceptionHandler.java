package unifaj.tcc.external.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import unifaj.tcc.businessrule.exception.QuestionException;
import unifaj.tcc.businessrule.exception.entities.ErrorData;
import unifaj.tcc.businessrule.exception.entities.MetaDataEnvelope;
import unifaj.tcc.businessrule.exception.entities.http.gatewayError.QuestionError;
import unifaj.tcc.businessrule.message.MessagesService;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

    private static final String BAD_REQUEST_CODE = HttpStatus.BAD_REQUEST.toString();
    private final MessagesService messagesService;

    @ExceptionHandler({QuestionException.class})
    public ResponseEntity<Object> questionException(final QuestionException exception) {

        Set<ErrorData> errors = new HashSet<>(Arrays.asList(
                new ErrorData(messagesService.getMessage("tcc-faj-api.already-exist-in-database-title"),
                messagesService.getMessage("tcc-faj-api.already-exist-in-database"))));

        final MetaDataEnvelope response = new MetaDataEnvelope(BAD_REQUEST_CODE, errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
