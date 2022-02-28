package vn.lotte.tsms.convention.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import vn.lotte.tsms.convention.constants.ResponseBodyConstants;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class LotteCommonResp<T> {
    private String returnCode;
    private String returnMessage;
    private T responseData;

    public static <T> LotteCommonResp<T> onSuccess() {
        return LotteCommonResp.<T>builder()
                .returnCode(ResponseBodyConstants.returnCode.CODE_0000.getValue())
                .returnMessage(ResponseBodyConstants.returnMessage.REQUEST_SUCCESS.getMessage())
                .build();
    }

    public static <T> LotteCommonResp<T> onSuccess(final T data) {
        return LotteCommonResp.<T>builder()
                .returnCode(ResponseBodyConstants.returnCode.CODE_0000.getValue())
                .returnMessage(ResponseBodyConstants.returnMessage.REQUEST_SUCCESS.getMessage())
                .responseData(data)
                .build();
    }

    public static <T> LotteCommonResp<T> onBadRequest() {
        return LotteCommonResp.<T>builder()
                .returnCode(ResponseBodyConstants.returnCode.CODE_4000.getValue())
                .returnMessage(
                        ResponseBodyConstants.returnMessage.REQUEST_IS_NOT_VALID.getMessage())
                .build();
    }

    public static <T> LotteCommonResp<T> onFailure(final String errMessage) {
        return LotteCommonResp.<T>builder()
                .returnCode(ResponseBodyConstants.returnCode.CODE_9999.getValue())
                .returnMessage(errMessage)
                .build();
    }
}
