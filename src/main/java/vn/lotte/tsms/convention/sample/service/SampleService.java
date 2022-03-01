package vn.lotte.tsms.convention.sample.service;


import vn.lotte.tsms.convention.sample.model.entites.Sample;
import vn.lotte.tsms.convention.exception.BusinessException;
import vn.lotte.tsms.convention.sample.model.request.SampleReq;
import vn.lotte.tsms.convention.sample.model.response.SampleResp;

import java.util.List;

public interface SampleService {

    SampleResp getSampleById(String id) ;

    List<SampleResp> getSamples();

    boolean createSample(SampleReq sampleReq) throws BusinessException;

    int updateSample(String id, SampleReq SampleReq);

    int deleteSample(String id) ;
}
