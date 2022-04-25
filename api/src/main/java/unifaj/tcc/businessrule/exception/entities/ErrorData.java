package unifaj.tcc.businessrule.exception.entities;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ErrorData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title;
    private String code;

    private String detail;

    public ErrorData(final String title, final String detail, final String code) {
        this.title = title;
        this.detail = detail;
        this.code = code;
    }

    public ErrorData(final String title, final String detail) {
        this.title = title;
        this.detail = detail;
    }

    public ErrorData(final ErrorData errorData) {
        this.detail = errorData.detail;
        this.title = errorData.title;
        this.code = errorData.code;
    }
}
