package vn.lotte.tsms.convention.sample.model;

import lombok.Getter;
import vn.lotte.tsms.convention.utility.ValidateUtil;

@Getter
public class SampleReq {
    private Sample sample;

    public boolean isValid(){
        return ((sample!=null) && (!ValidateUtil.isEmpty(sample.getId())));
    }
}
