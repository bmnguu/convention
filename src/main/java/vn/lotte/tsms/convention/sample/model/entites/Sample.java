package vn.lotte.tsms.convention.sample.model.entites;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.lotte.tsms.convention.sample.model.request.SampleReq;

import java.sql.Timestamp;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class Sample {
    private String id;
    private String name;
    private String status;
    private Timestamp created;

    public Sample(SampleReq req) {
        if (req != null) {
            this.name = req.getName();
            this.status = req.getStatus();
        }
    }
}
