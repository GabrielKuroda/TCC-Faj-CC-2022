package unifaj.tcc.businessrule.message;

public interface MessagesService {

    public String getMessage(String messageProperty);

    public String getMessage(String messageProperty, Object... messageArgs);

}
