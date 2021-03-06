package uk.gov.hmcts.reform.cmc.submit.ccd.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Data
public class CcdCase {

    private String externalId;
    private String referenceNumber;
    private String reason;

    private AmountType amountType;
    private BigInteger amountLowerValue;
    private BigInteger amountHigherValue;
    private List<CcdCollectionElement<CcdAmountRow>> amountBreakDown;
    private BigInteger totalAmount;

    private CcdInterestType interestType;
    private BigDecimal interestBreakDownAmount;
    private String interestBreakDownExplanation;
    private BigDecimal interestRate;
    private String interestReason;
    private BigDecimal interestSpecificDailyAmount;
    private CcdInterestDateType interestDateType;
    private LocalDate interestClaimStartDate;
    private String interestStartDateReason;
    private CcdInterestEndDateType interestEndDateType;

    private String paymentId;
    private BigInteger paymentAmount;
    private String paymentReference;
    private String paymentStatus;
    private LocalDate paymentDateCreated;
    private String feeAccountNumber;

    private String preferredCourt;
    private String personalInjuryGeneralDamages;
    private String housingDisrepairCostOfRepairDamages;
    private String housingDisrepairOtherDamages;
    private String sotSignerName;
    private String sotSignerRole;

    private List<CcdCollectionElement<CcdApplicant>> applicants;
    private List<CcdCollectionElement<CcdRespondent>> respondents;
    private List<CcdCollectionElement<CcdTimelineEvent>> timeline;
    private List<CcdCollectionElement<CcdEvidenceRow>> evidence;
}
