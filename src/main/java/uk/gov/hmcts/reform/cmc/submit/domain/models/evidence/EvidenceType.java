package uk.gov.hmcts.reform.cmc.submit.domain.models.evidence;

public enum EvidenceType {
    CONTRACTS_AND_AGREEMENTS("Contracts and agreements"),
    EXPERT_WITNESS("Expert witness"),
    CORRESPONDENCE("Letters, emails and other correspondence"),
    PHOTO("Photo evidence"),
    RECEIPTS("Receipts"),
    STATEMENT_OF_ACCOUNT("Statements of account"),
    OTHER("Other");

    String description;

    EvidenceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
