package vn.lotte.tsms.convention.constants;

public class ResponseBodyConstants {

    public enum returnCode {
        CODE_0000("0000"),
        CODE_4000("4000"),
        CODE_9999("9999");

        private String value;

        private returnCode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum returnMessage {
        REQUEST_SUCCESS("Request success"),
        REQUEST_IS_NOT_VALID("Request is not valid"),
        INTERNAL_SERVER_ERROR("Internal server error");

        private String message;

        private returnMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
