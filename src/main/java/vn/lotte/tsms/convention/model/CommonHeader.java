package vn.lotte.tsms.convention.model;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.lotte.tsms.convention.constants.CommonConstants;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
public class CommonHeader {
    @Builder.Default private String trnmSysCode = "PNP";
    @Builder.Default private String ipAddr = "127000000001";
    @Builder.Default private String tlgrCretDttm = "";
    @Builder.Default private String rndmNo = "1234";
    @Builder.Default private int hsno = 1;
    @Builder.Default private String ctfnTokn = "";
    @Builder.Default private String ogtsTrnnNo = "";
    @Builder.Default private String prsnInfoIncsYn = "N";
    @Builder.Default private String itfcId = "HLIPNP0001";
    @Builder.Default private String rcveSrvcId = "";
    @Builder.Default private String rcveSysCode = "";
    @Builder.Default private String mciNodeNo = "";
    @Builder.Default private String mciSesnId = "";
    @Value("${esb.to-be.server-type}")
    private String serverType;
    @Builder.Default private String rspnDvsnCode = "R";
    @Builder.Default private String extlDvsnCode = "1";
    @Builder.Default private String emnb = "";
    @Builder.Default private String belnOrgnCode = "";
    @Builder.Default private String custId = "";
    @Builder.Default private String chnlTypeCode = "1";
    @Builder.Default private String scrnId = "";
    @Builder.Default private String befoScrnId = "";
    @Builder.Default private String userTmunIdnfVal = "";
    @Builder.Default private String rqsrIp = "127.0.0.1";
    @Builder.Default private String rqstDttm = "";
    @Builder.Default private String baseCrny = "KRW";
    @Builder.Default private String baseCnty = "KO";
    @Builder.Default private String baseLang = "kor";

    @Builder.Default
    private String tlgrRspnDttm =
            LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern(CommonConstants.PAGING_DATETIME_FORMAT));

    @Builder.Default private String prcsRsltDvsnCode = "1";
    @Builder.Default private int totalCount = 0;
    @Builder.Default private String lastPageYn = "0";

    @Builder.Default private int msgeListCont = 0;
    private CommonHeaderMessage[] msgeList;

    @Builder.Default private String msgeStackTrace = "";
}
