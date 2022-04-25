package unifaj.tcc.businessrule.message;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Service
@RequiredArgsConstructor
public class MessagesServiceImlp implements MessagesService{

    private final MessageSource messageSource;

    @Override
    public String getMessage(String messageProperty) {
        return messageSource.getMessage(messageProperty, null, getLocale());
    }

    @Override
    public String getMessage(String messageProperty, Object... messageArgs) {
        return messageSource.getMessage(messageProperty, messageArgs, getLocale());
    }
}
