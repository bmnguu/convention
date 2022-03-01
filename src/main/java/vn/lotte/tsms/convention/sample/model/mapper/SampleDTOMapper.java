package vn.lotte.tsms.convention.sample.model.mapper;

import vn.lotte.tsms.convention.sample.model.entites.Sample;
import vn.lotte.tsms.convention.sample.model.response.SampleResp;

public class SampleDTOMapper {

    private static SampleResp.SampleRespBuilder baseFromEntity(Sample sample) {
        SampleResp.SampleRespBuilder builder = SampleResp.builder();
        if(sample !=null) {
            builder
                    .id(sample.getId())
                    .name(sample.getName())
                    .status(sample.getStatus())
                    .created(sample.getCreated());
        }
        return builder;
    }

    public static SampleResp fromSampleEntity(Sample sample) {
        return baseFromEntity(sample).build();
    }
}
