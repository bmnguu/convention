package vn.lotte.tsms.convention.sample.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import vn.lotte.tsms.convention.sample.model.Sample;

@Mapper
public interface SampleRepository {
    boolean insertSample(Sample sample) ;

    int deleteSample(Sample sample) ;

    Sample selectSampleDetail(String id);

    List<Sample> selectSample(Sample sample) ;

    List<Sample> selectSampleAll() ;

    int updateSample(Sample sample) ;
}
