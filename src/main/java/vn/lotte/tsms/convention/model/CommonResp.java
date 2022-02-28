package vn.lotte.tsms.convention.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class CommonResp<T> {
    private T payload;
    private CommonHeader header;

    public static <T> CommonResp<T> onFailure(final String msgeStackTrace) {
        return CommonResp.<T>builder()
                .header(CommonHeader.builder().msgeStackTrace(msgeStackTrace).build())
                .build();
    }

    public static <T> CommonResp<T> onSuccess(final T payload) {
        return CommonResp.<T>builder()
                .header(CommonHeader.builder().build())
                .payload(payload)
                .build();
    }

    public void emptyMethodForPassCpsp() {
        // cpsp
    }
}
