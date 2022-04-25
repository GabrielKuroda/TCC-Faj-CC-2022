package unifaj.tcc.businessrule.exception.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetaDataEnvelope<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Set<ErrorData> errors = new HashSet<>();
    private final MetaData meta;
    @JsonUnwrapped
    private T successData;

    public MetaDataEnvelope(final String statusCode,
                            final ErrorCode code,
                            final String message) {
        this.meta = new MetaData(statusCode);
        this.addErrorData(statusCode, code, message);
        this.updateErrorCode();

    }

    public MetaDataEnvelope(final String statusCode,
                            final Set<ErrorData> errors) {
        this.meta = new MetaData(statusCode);
        this.errors.addAll(errors);
        this.updateErrorCode();
    }

    public MetaDataEnvelope(final MetaData meta,
                            final Set<ErrorData> errors) {
        this.meta = meta;
        this.errors.addAll(errors);
        this.updateErrorCode();
    }

    private void updateErrorCode() {
        if (this.meta != null) {
            this.errors.forEach(error -> error.setCode(this.meta.getMeta()));
        }
    }

    private void addErrorData(final String detail,
                              final ErrorCode errorCode,
                              final String code) {
        this.errors.add(ErrorData.builder()
                .detail(detail)
                .title(errorCode.name() + " " + code)
                .build());

    }
}
