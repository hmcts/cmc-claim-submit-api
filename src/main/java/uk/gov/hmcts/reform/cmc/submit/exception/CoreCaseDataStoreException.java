package uk.gov.hmcts.reform.cmc.submit.exception;

public class CoreCaseDataStoreException extends RuntimeException {
    public CoreCaseDataStoreException(String message) {
        super(message);
    }

    public CoreCaseDataStoreException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
