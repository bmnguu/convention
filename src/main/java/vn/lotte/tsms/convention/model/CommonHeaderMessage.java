package vn.lotte.tsms.convention.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

// import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
// @NoArgsConstructor
@Data
@Builder
public class CommonHeaderMessage {
    @Builder.Default private String msgeCode = "PNP0000";
    @Builder.Default private String msgeCntn = "processed normally";
    @Builder.Default private String msgeOtptDvsnCode = "0";
}
