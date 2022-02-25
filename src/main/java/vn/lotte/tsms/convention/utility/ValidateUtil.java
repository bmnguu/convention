package vn.lotte.tsms.convention.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;
import vn.lotte.tsms.convention.constants.StatusCodeConstants;

public final class ValidateUtil {
    private ValidateUtil() {
        // Avoid utility class declarations
    }

    public static Boolean invalidDateFormat(final String uploadFileName) {
        return !Pattern.compile("^[^_]+_{1}[0-9]{12}[^_]+$").matcher(uploadFileName).find();
    }

    public static Boolean checkYyyymm(final String yyyymm) {
        String regExp = "(19|20)\\d{2}(0[1-9]|1[012])";
        return yyyymm.matches(regExp);
    }

    public static String checkFromYyyymm(final String startYyyymm) {
        String yyyymm = new SimpleDateFormat("yyyyMM", Locale.KOREAN).format(new Date());
        if (!checkYyyymm(startYyyymm)) {
            return StatusCodeConstants.INVALID_FORMAT;
        } else if (Integer.parseInt(startYyyymm) > Integer.parseInt(yyyymm)) {
            return StatusCodeConstants.INVALID_FUTURE_DATE;
        } else {
            return StatusCodeConstants.OK;
        }
    }

    public static String checkFromToYyyymm(final String startYyyymm, final String endYyyymm) {
        String yyyymm = new SimpleDateFormat("yyyyMM", Locale.KOREAN).format(new Date());
        if (!checkYyyymm(startYyyymm) || !checkYyyymm(endYyyymm)) {
            return StatusCodeConstants.INVALID_FORMAT;
        } else if (Integer.parseInt(startYyyymm) > Integer.parseInt(endYyyymm)) {
            return StatusCodeConstants.INVALID_DATE_FROM_TO;
        } else if (Integer.parseInt(endYyyymm) > Integer.parseInt(yyyymm)
                || Integer.parseInt(startYyyymm) > Integer.parseInt(yyyymm)) {
            return StatusCodeConstants.INVALID_FUTURE_DATE;
        } else {
            return StatusCodeConstants.OK;
        }
    }

    public static boolean checkNicknameFormat(final String nickname) {
        String regExp = "^[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣!@$^*\\-_\\s]{2,20}$"; // kor, eng, num, !@$^*-_, space
        return nickname.matches(regExp);
    }

    public static boolean checkEmail(final String email) {
        String regExp =
                "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z]?)*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*[.][a-zA-Z]{2,3}$";
        return email.matches(regExp);
    }

    public static boolean checkPhoneNumber(final String phoneNumber) {
        String regExp = "^[0-9]+$";
        return phoneNumber.matches(regExp);
    }

    public static boolean isEmpty(Object s) {
        if (s == null) {
            return true;
        }
        if (s instanceof String) {
            return !StringUtils.hasText(String.valueOf(s));
        }
        if (s instanceof Map) {
            return ((Map<?, ?>) s).isEmpty();
        }
        if (s instanceof List) {
            return ((List<?>) s).isEmpty();
        }
        if (s instanceof Object[]) {
            return (((Object[]) s).length == 0);
        }
        return false;
    }

    public static boolean isEmptyStr(String str) {
        return !StringUtils.hasText(str);
    }
}
