package vn.lotte.tsms.convention.sample.service;


import vn.lotte.tsms.convention.sample.model.Sample;
import vn.lotte.tsms.convention.exception.BusinessException;
import vn.lotte.tsms.convention.sample.model.SampleResp;

import java.util.List;

public interface SampleService {
    public Sample getSampleById(String id) ;

    public SampleResp getSamples();

    public boolean createSample(Sample sample) throws BusinessException;

    public int updateSample(Sample sample);

    public int deleteSample(Sample sample) ;
}
