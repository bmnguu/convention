package vn.lotte.tsms.convention.sample.model.response;

import lombok.Builder;
import lombok.Data;
import vn.lotte.tsms.convention.sample.model.entites.Sample;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class SampleResp {

    private String id;

    private String name;

    private String status;

    private Timestamp created;

}
