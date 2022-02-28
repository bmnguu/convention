package vn.lotte.tsms.convention.healthy;

import static org.springframework.http.HttpStatus.OK;


import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.lotte.tsms.convention.constants.ResponseBodyConstants.returnCode;
import vn.lotte.tsms.convention.constants.ResponseBodyConstants.returnMessage;
import vn.lotte.tsms.convention.exception.BusinessException;
import vn.lotte.tsms.convention.model.LotteCommonResp;



@RestController
public class HealthyController {
    @ApiOperation(value = "health check", httpMethod = "GET", notes = "health check")
    @GetMapping(path = "/healthy", produces = "application/json")
    public ResponseEntity<LotteCommonResp<String>> retrieveHealthy() throws BusinessException {
        try {
            return new ResponseEntity<>(
                    LotteCommonResp.<String>builder()
                            .returnCode(returnCode.CODE_0000.getValue())
                            .returnMessage(returnMessage.REQUEST_SUCCESS.getMessage())
                            .responseData("UP")
                            .build(),
                    OK);
        } catch (Exception ex) {
            throw new BusinessException(ex.getMessage(), HttpStatus.CONFLICT.toString());
        }
    }
}
