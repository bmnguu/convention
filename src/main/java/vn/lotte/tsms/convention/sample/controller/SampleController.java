package vn.lotte.tsms.convention.sample.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.lotte.tsms.convention.constants.ResponseBodyConstants;
import vn.lotte.tsms.convention.constants.StatusCodeConstants;
import vn.lotte.tsms.convention.exception.BusinessException;
import vn.lotte.tsms.convention.model.CommonHeader;
import vn.lotte.tsms.convention.model.CommonResp;
import vn.lotte.tsms.convention.model.LotteCommonResp;
import vn.lotte.tsms.convention.sample.model.entites.Sample;
import vn.lotte.tsms.convention.sample.model.request.SampleReq;
import vn.lotte.tsms.convention.sample.model.response.SampleResp;
import vn.lotte.tsms.convention.sample.service.SampleService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @ApiOperation(value = "get id sample", httpMethod = "GET", notes = "get id sample")
    @GetMapping(path =  "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LotteCommonResp<SampleResp>> getSampleById(@PathVariable String id) {
        return new ResponseEntity<>(
                LotteCommonResp.<SampleResp>builder()
                        .returnCode(ResponseBodyConstants.returnCode.CODE_0000.getValue())
                        .returnMessage(ResponseBodyConstants.returnMessage.REQUEST_SUCCESS.getMessage())
                        .responseData(sampleService.getSampleById(id))
                        .build(),
                HttpStatus.OK
        );
    }

    @ApiOperation(value = "get list sample", httpMethod = "GET", notes = "get list sample")
    @GetMapping()
    public ResponseEntity<LotteCommonResp<List<SampleResp>>> getSamples() {
        return ResponseEntity.ok(LotteCommonResp.onSuccess(sampleService.getSamples()));
    }

    @ApiOperation(value  = "insert", httpMethod = "POST", notes = "insert sample")
    @PostMapping(path =   "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResp<Boolean>> insert(@Valid SampleReq sampleReq) throws BusinessException {
        boolean result = sampleService.createSample(sampleReq);

        return new ResponseEntity<>(
                CommonResp.<Boolean>builder()
                        .payload(result)
                        .build(),
                HttpStatus.OK
        );
    }
}
