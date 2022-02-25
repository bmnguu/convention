package vn.lotte.tsms.convention.sample.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class Sample {
    private String id;
    private String name;
    private String status;
    private String birthDate;
    private String useYn;
    private String createdDatetime;
    private String createId;
    private String updatedDatetime;
    private String updateId;
    private String crudCode;
}
