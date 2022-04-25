package unifaj.tcc.businessrule.exception.entities.http.gatewayError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
@Builder
public class QuestionError implements Serializable {

    private static final long serialVersionUID = -2723198347658877204L;
    private String title;
    private String code;
    private String detail;

}
