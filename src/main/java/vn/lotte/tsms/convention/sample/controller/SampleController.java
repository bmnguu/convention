package vn.lotte.tsms.convention.sample.controller;


import java.nio.charset.Charset;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.lotte.tsms.convention.exception.BusinessException;
import vn.lotte.tsms.convention.model.CommonResp;
import vn.lotte.tsms.convention.sample.model.Sample;
import vn.lotte.tsms.convention.sample.model.SampleResp;
import vn.lotte.tsms.convention.sample.service.SampleService;

@RestController
@RequestMapping(SampleController.URL_BASE)
public class SampleController {
    public static final String URL_BASE = "/v1/sample";
    public static final String URL_SELECTBYEMAIL = "/selectByEmail";
    public static final String URL_INSERT = "/insert";

    @Autowired private SampleService sampleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sample> getSampleById(@PathVariable String id) {
        Sample sample = sampleService.getSampleById(id);

        ResponseEntity<Sample> re = null;
        if (sample != null) {
            re = new ResponseEntity<>(sample, HttpStatus.OK);
        } else {
            re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return re;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<CommonResp<SampleResp>> getSamples() {
        return ResponseEntity.ok(CommonResp.onSuccess(sampleService.getSamples()));
    }

    @PostMapping(value = URL_INSERT)
    @ResponseBody
    public ResponseEntity<Boolean> insert(@RequestBody Sample sample, HttpServletRequest req) throws BusinessException {
        boolean result = sampleService.createSample(sample);

        ResponseEntity<Boolean> re = null;
        if (result) {
            re = new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            re = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return re;
    }
}
