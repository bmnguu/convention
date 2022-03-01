package vn.lotte.tsms.convention.sample.model.request;

import lombok.Getter;
import lombok.Setter;
import vn.lotte.tsms.convention.sample.model.entites.Sample;
import vn.lotte.tsms.convention.utility.ValidateUtil;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SampleReq {

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than or equal 255 characters")
    private String name;

    @NotBlank(message = "status is required")
    @Size(max = 255, message = "status must be less than or equal 255 characters")
    private String status;
}
