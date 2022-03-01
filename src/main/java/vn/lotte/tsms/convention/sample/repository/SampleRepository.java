package vn.lotte.tsms.convention.sample.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vn.lotte.tsms.convention.sample.model.entites.Sample;

@Mapper
@Repository
public interface SampleRepository {
    boolean insertSample(Sample sample) ;

    int deleteSample(Sample sample) ;

    Sample getSampleDetail(String id);


    List<Sample> selectSampleAll() ;

    int updateSample(Sample sample) ;
}
