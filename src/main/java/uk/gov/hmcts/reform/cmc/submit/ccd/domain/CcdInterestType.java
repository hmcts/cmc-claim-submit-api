package uk.gov.hmcts.reform.cmc.submit.ccd.domain;

public enum CcdInterestType {
    STANDARD("standard"),
    BREAKDOWN("breakdown"),
    DIFFERENT("different"),
    NO_INTEREST("no interest");

    private String value;

    CcdInterestType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
