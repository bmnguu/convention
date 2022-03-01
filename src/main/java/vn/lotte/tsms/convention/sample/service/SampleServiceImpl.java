package vn.lotte.tsms.convention.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.lotte.tsms.convention.constants.StatusCodeConstants;
import vn.lotte.tsms.convention.sample.model.entites.Sample;
import vn.lotte.tsms.convention.sample.model.mapper.SampleDTOMapper;
import vn.lotte.tsms.convention.sample.model.request.SampleReq;
import vn.lotte.tsms.convention.sample.model.response.SampleResp;
import vn.lotte.tsms.convention.sample.repository.SampleRepository;
import vn.lotte.tsms.convention.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    @Override
    public SampleResp getSampleById(final String id) {
        return SampleDTOMapper.fromSampleEntity(sampleRepository.getSampleDetail(id));
    }

    @Override
    public List<SampleResp> getSamples() {
        List<Sample> samples = sampleRepository.selectSampleAll();
        List<SampleResp> sampleResps = new ArrayList<>();
        if(!CollectionUtils.isEmpty(samples)) {
            for(Sample sample: samples) {
                sampleResps.add(SampleDTOMapper.fromSampleEntity(sample));
            }
        }
        return sampleResps;
    }

    @Override
    public boolean createSample(SampleReq sampleReq) {
        Sample sample = new Sample(sampleReq);
        return sampleRepository.insertSample(sample);
    }

    @Override
    public int updateSample(String id, SampleReq sampleReq) {
        return 0;
    }

    @Override
    public int deleteSample(String id)  {
        return 0;
    }
}
