package vn.lotte.tsms.convention.sample.controller;


import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.lotte.tsms.convention.constants.ResponseBodyConstants;
import vn.lotte.tsms.convention.constants.StatusCodeConstants;
import vn.lotte.tsms.convention.exception.BusinessException;
import vn.lotte.tsms.convention.model.CommonHeader;
import vn.lotte.tsms.convention.model.CommonResp;
import vn.lotte.tsms.convention.model.LotteCommonResp;
import vn.lotte.tsms.convention.sample.model.Sample;
import vn.lotte.tsms.convention.sample.model.SampleReq;
import vn.lotte.tsms.convention.sample.model.SampleResp;
import vn.lotte.tsms.convention.sample.service.SampleService;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
public class SampleController {
    public static final String URL_BASE = "/v1/sample";
    public static final String URL_INSERT = "/insert";

    @Autowired
    private SampleService sampleService;
    @ApiOperation(value = "get id sample", httpMethod = "GET", notes = "get id sample")
    @GetMapping(path = URL_BASE+ "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LotteCommonResp<Sample>> getSampleById(@PathVariable String id) {
        Sample sample = sampleService.getSampleById(id);

        return new ResponseEntity<>(
                LotteCommonResp.<Sample>builder()
                        .returnCode(ResponseBodyConstants.returnCode.CODE_0000.getValue())
                        .returnMessage(ResponseBodyConstants.returnMessage.REQUEST_SUCCESS.getMessage())
                        .responseData(sample)
                        .build(),
                HttpStatus.OK
        );
    }

    @ApiOperation(value = "get list sample", httpMethod = "GET", notes = "get list sample")
    @GetMapping(path = URL_BASE+ "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LotteCommonResp<SampleResp>> getSamples() {
        return ResponseEntity.ok(LotteCommonResp.onSuccess(sampleService.getSamples()));
    }

    @ApiOperation(value = "insert", httpMethod = "POST", notes = "insert sample")
    @PostMapping(path =  URL_BASE+ URL_INSERT,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<CommonResp<Boolean>> insert(@RequestBody final SampleReq sampleReq, HttpServletRequest req) throws BusinessException {

        if (!sampleReq.isValid()){
            return new ResponseEntity<>(
              CommonResp.<Boolean>builder()
                      .header(
                              CommonHeader.builder()
                                      .msgeStackTrace(StatusCodeConstants.MANDATORY_PARAM_ERR)
                                      .build())
                      .build(),INTERNAL_SERVER_ERROR
            );
        }

        boolean result = sampleService.createSample(sampleReq.getSample());

        return new ResponseEntity<>(
                CommonResp.<Boolean>builder()
                        .payload(result)
                        .build(),
                HttpStatus.OK
        );
    }
}
