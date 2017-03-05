package nz.co.automation.regression.io.random;

public enum RandomKeyWord {
    RANDOM_TEXT_NUMBER("#RANDOM_TEXT_NUMBER#"),
    RANDOM_TEXT("#RANDOM_TEXT#"),
    RANDOM_EMAIL("#RANDOM_EMAIL#"),
    RANDOM_NUMBER("#RANDOM_NUMBER#"),
    RANDOM_DATE("#RANDOM_DATE#");

    private final String code;

    RandomKeyWord(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
