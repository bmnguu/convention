package vn.lotte.tsms.convention.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.lotte.tsms.convention.constants.StatusCodeConstants;
import vn.lotte.tsms.convention.sample.model.Sample;
import vn.lotte.tsms.convention.sample.model.SampleResp;
import vn.lotte.tsms.convention.sample.repository.SampleRepository;
import vn.lotte.tsms.convention.exception.BusinessException;

import java.util.List;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
    @Autowired private SampleRepository sampleRepository;

    @Override
    public Sample getSampleById(final String id) {
        Sample test = new Sample();
        test.setId(id);
        Sample result = sampleRepository.selectSampleDetail(id);
        return result;
    }

    @Override
    public SampleResp getSamples() {
        SampleResp sampleResp = new SampleResp();
        sampleResp.setSampleList(sampleRepository.selectSampleAll());

        return sampleResp;
    }

    @Override
    public boolean createSample(final Sample sample) throws BusinessException {
        if (sample.getName() == null || "".equals(sample.getName())) {
            throw new BusinessException(
                    "Name is mandatory param", StatusCodeConstants.MANDATORY_PARAM_ERR);
        }
        boolean result = sampleRepository.insertSample(sample);
        return result;
    }

    @Override
    public int updateSample(final Sample sample) {
        int result = sampleRepository.updateSample(sample);
        return result;
    }

    @Override
    public int deleteSample(final Sample sample)  {
        int result = sampleRepository.deleteSample(sample);
        return result;
    }
}
