package uk.gov.hmcts.reform.cmc.ccd.util;

import uk.gov.hmcts.cmc.ccd.domain.CcdAddress;
import uk.gov.hmcts.cmc.ccd.domain.CcdAmountRow;
import uk.gov.hmcts.cmc.ccd.domain.CcdApplicant;
import uk.gov.hmcts.cmc.ccd.domain.CcdCase;
import uk.gov.hmcts.cmc.ccd.domain.CcdCollectionElement;
import uk.gov.hmcts.cmc.ccd.domain.CcdInterestDateType;
import uk.gov.hmcts.cmc.ccd.domain.CcdInterestEndDateType;
import uk.gov.hmcts.cmc.ccd.domain.CcdInterestType;
import uk.gov.hmcts.cmc.ccd.domain.CcdParty;
import uk.gov.hmcts.cmc.ccd.domain.CcdRespondent;
import uk.gov.hmcts.cmc.ccd.domain.CcdTelephone;
import uk.gov.hmcts.cmc.ccd.domain.CcdTimelineEvent;
import uk.gov.hmcts.cmc.ccd.domain.evidence.CcdEvidenceRow;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static uk.gov.hmcts.cmc.ccd.domain.AmountType.BREAK_DOWN;
import static uk.gov.hmcts.cmc.ccd.domain.AmountType.RANGE;
import static uk.gov.hmcts.cmc.ccd.domain.CcdPartyType.COMPANY;
import static uk.gov.hmcts.cmc.ccd.domain.CcdPartyType.INDIVIDUAL;
import static uk.gov.hmcts.cmc.ccd.domain.CcdPartyType.ORGANISATION;
import static uk.gov.hmcts.cmc.ccd.domain.CcdPartyType.SOLE_TRADER;
import static uk.gov.hmcts.cmc.ccd.domain.evidence.CcdEvidenceType.EXPERT_WITNESS;
import static uk.gov.hmcts.reform.cmc.submit.domain.models.particulars.DamagesExpectation.MORE_THAN_THOUSAND_POUNDS;
import static uk.gov.hmcts.reform.cmc.submit.domain.models.particulars.DamagesExpectation.THOUSAND_POUNDS_OR_LESS;

public class SampleData {

    //Utility class
    private SampleData() {
    }

    public static List<CcdCollectionElement<CcdAmountRow>> getAmountBreakDown() {
        return singletonList(CcdCollectionElement.<CcdAmountRow>builder().value(CcdAmountRow.builder()
            .amount(BigDecimal.valueOf(50))
            .reason("payment")
            .build()).build());
    }

    public static CcdAddress getCcdAddress() {
        return CcdAddress.builder()
            .addressLine1("line1")
            .addressLine2("line2")
            .addressLine3("line3")
            .postTown("city")
            .postCode("postcode")
            .build();
    }

    public static CcdRespondent getCcdDefendantIndividual() {
        CcdAddress ccdAddress = getCcdAddress();
        return CcdRespondent.builder()
            .claimantProvidedType(INDIVIDUAL)
            .claimantProvidedAddress(ccdAddress)
            .claimantProvidedName("Individual")
            .claimantProvidedDateOfBirth(LocalDate.of(1950, 01, 01))
            .claimantProvidedServiceAddress(ccdAddress)
            .claimantProvidedRepresentativeOrganisationAddress(ccdAddress)
            .claimantProvidedRepresentativeOrganisationName("My Org")
            .claimantProvidedRepresentativeOrganisationPhone("07987654321")
            .claimantProvidedRepresentativeOrganisationEmail("my@email.com")
            .claimantProvidedRepresentativeOrganisationDxAddress("dx123")
            .build();
    }

    public static CcdRespondent getCcdDefendantOrganisation() {
        CcdAddress ccdAddress = getCcdAddress();
        return CcdRespondent.builder()
            .claimantProvidedType(ORGANISATION)
            .claimantProvidedAddress(ccdAddress)
            .claimantProvidedName("Organisation")
            .claimantProvidedServiceAddress(ccdAddress)
            .claimantProvidedRepresentativeOrganisationAddress(ccdAddress)
            .claimantProvidedRepresentativeOrganisationName("My Org")
            .claimantProvidedRepresentativeOrganisationPhone("07987654321")
            .claimantProvidedRepresentativeOrganisationEmail("my@email.com")
            .claimantProvidedRepresentativeOrganisationDxAddress("dx123")
            .claimantProvidedContactPerson("MR. Hyde")
            .claimantProvidedCompaniesHouseNumber("12345678")
            .build();
    }

    public static CcdRespondent getCcdDefendantCompany() {
        CcdAddress ccdAddress = getCcdAddress();
        return CcdRespondent.builder()
            .claimantProvidedType(COMPANY)
            .claimantProvidedAddress(ccdAddress)
            .claimantProvidedName("Abc Ltd")
            .claimantProvidedAddress(ccdAddress)
            .claimantProvidedServiceAddress(ccdAddress)
            .claimantProvidedRepresentativeOrganisationAddress(ccdAddress)
            .claimantProvidedRepresentativeOrganisationName("My Org")
            .claimantProvidedRepresentativeOrganisationPhone("07987654321")
            .claimantProvidedRepresentativeOrganisationEmail("my@email.com")
            .claimantProvidedRepresentativeOrganisationDxAddress("dx123")
            .claimantProvidedContactPerson("MR. Hyde")
            .build();
    }

    public static CcdRespondent getCcdDefendantSoleTrader() {
        CcdAddress ccdAddress = getCcdAddress();
        return CcdRespondent.builder()
            .claimantProvidedType(SOLE_TRADER)
            .claimantProvidedAddress(ccdAddress)
            .claimantProvidedTitle("Mr.")
            .claimantProvidedName("SoleTrader")
            .claimantProvidedBusinessName("My Trade")
            .claimantProvidedServiceAddress(ccdAddress)
            .claimantProvidedRepresentativeOrganisationAddress(ccdAddress)
            .claimantProvidedRepresentativeOrganisationName("My Org")
            .claimantProvidedRepresentativeOrganisationPhone("07987654321")
            .claimantProvidedRepresentativeOrganisationEmail("my@email.com")
            .claimantProvidedRepresentativeOrganisationDxAddress("dx123")
            .build();
    }

    public static CcdApplicant getCcdClaimantIndividual() {
        CcdAddress ccdAddress = getCcdAddress();
        return CcdApplicant.builder()
            .partyName("Individual")
            .partyDetail(CcdParty.builder()
                    .type(INDIVIDUAL)
                    .primaryAddress(ccdAddress)
                    .telephoneNumber(CcdTelephone.builder().telephoneNumber("07987654321").build())
                    .dateOfBirth(LocalDate.of(1950, 01, 01))
                    .correspondenceAddress(ccdAddress).build())
            .representativeOrganisationAddress(ccdAddress)
            .representativeOrganisationName("My Org")
            .representativeOrganisationPhone("07987654321")
            .representativeOrganisationEmail("my@email.com")
            .representativeOrganisationDxAddress("dx123")
            .build();
    }

    public static CcdApplicant getCcdClaimantCompany() {
        CcdAddress ccdAddress = getCcdAddress();

        return CcdApplicant.builder()
            .partyName("Abc Ltd")
            .partyDetail(CcdParty.builder()
                    .type(COMPANY)
                    .primaryAddress(ccdAddress)
                    .telephoneNumber(CcdTelephone.builder().telephoneNumber("07987654321").build())
                    .correspondenceAddress(ccdAddress)
                    .contactPerson("MR. Hyde").build())
            .representativeOrganisationAddress(ccdAddress)
            .representativeOrganisationName("My Org")
            .representativeOrganisationPhone("07987654321")
            .representativeOrganisationEmail("my@email.com")
            .representativeOrganisationDxAddress("dx123")
            .build();
    }

    public static CcdApplicant getCcdClaimantOrganisation() {
        CcdAddress ccdAddress = getCcdAddress();

        return CcdApplicant.builder()
            .partyName("Xyz & Co")
            .partyDetail(CcdParty.builder()
                    .type(ORGANISATION)
                    .primaryAddress(ccdAddress)
                    .telephoneNumber(CcdTelephone.builder().telephoneNumber("07987654321").build())
                    .correspondenceAddress(ccdAddress)
                    .contactPerson("MR. Hyde")
                    .companiesHouseNumber("12345678").build())
            .representativeOrganisationAddress(ccdAddress)
            .representativeOrganisationName("My Org")
            .representativeOrganisationPhone("07987654321")
            .representativeOrganisationEmail("my@email.com")
            .representativeOrganisationDxAddress("dx123")
            .build();
    }

    public static CcdApplicant getCcdClaimantSoleTrader() {
        CcdAddress ccdAddress = getCcdAddress();

        return CcdApplicant.builder()
            .partyName("Individual")
            .partyDetail(CcdParty.builder()
                    .type(SOLE_TRADER)
                    .title("Mr.")
                    .businessName("My Trade")
                    .telephoneNumber(CcdTelephone.builder().telephoneNumber("07987654321").build())
                    .primaryAddress(ccdAddress)
                    .correspondenceAddress(ccdAddress).build())
            .representativeOrganisationAddress(ccdAddress)
            .representativeOrganisationName("My Org")
            .representativeOrganisationPhone("07987654321")
            .representativeOrganisationEmail("my@email.com")
            .representativeOrganisationDxAddress("dx123")
            .build();
    }

    public static CcdCase getCcdLegalCase() {
        List<CcdCollectionElement<CcdApplicant>> claimants
            = singletonList(CcdCollectionElement.<CcdApplicant>builder().value(getCcdClaimantIndividual()).build());
        List<CcdCollectionElement<CcdRespondent>> defendants
            = singletonList(CcdCollectionElement.<CcdRespondent>builder().value(getCcdDefendantIndividual()).build());
        return CcdCase.builder()
            .amountType(RANGE)
            .amountLowerValue(BigDecimal.valueOf(50))
            .amountHigherValue(BigDecimal.valueOf(500))
            .housingDisrepairCostOfRepairDamages(MORE_THAN_THOUSAND_POUNDS.name())
            .housingDisrepairOtherDamages(THOUSAND_POUNDS_OR_LESS.name())
            .personalInjuryGeneralDamages(MORE_THAN_THOUSAND_POUNDS.name())
            .sotSignerName("name")
            .sotSignerRole("role")
            .externalId(UUID.randomUUID().toString())
            .feeAccountNumber("PBA1234567")
            .reason("Reason for the case")
            .preferredCourt("London Court")
            .applicants(claimants)
            .respondents(defendants)
            .build();
    }

    public static CcdCase getCcdCitizenCase(List<CcdCollectionElement<CcdAmountRow>> amountBreakDown) {
        List<CcdCollectionElement<CcdApplicant>> claimants
            = singletonList(CcdCollectionElement.<CcdApplicant>builder().value(getCcdClaimantIndividual()).build());
        List<CcdCollectionElement<CcdRespondent>> defendants
            = singletonList(CcdCollectionElement.<CcdRespondent>builder().value(getCcdDefendantIndividual()).build());

        return CcdCase.builder()
            .externalId(UUID.randomUUID().toString())
            .amountType(BREAK_DOWN)
            .amountBreakDown(amountBreakDown)
            .housingDisrepairCostOfRepairDamages(MORE_THAN_THOUSAND_POUNDS.name())
            .housingDisrepairOtherDamages(THOUSAND_POUNDS_OR_LESS.name())
            .personalInjuryGeneralDamages(MORE_THAN_THOUSAND_POUNDS.name())
            .sotSignerName("name")
            .sotSignerRole("role")
            .reason("Reason for the case")
            .preferredCourt("London Court")
            .interestType(CcdInterestType.DIFFERENT)
            .interestReason("reason")
            .interestRate(BigDecimal.valueOf(2))
            .interestBreakDownAmount(BigDecimal.valueOf(210))
            .interestBreakDownExplanation("Explanation")
            .interestStartDateReason("start date reason")
            .interestDateType(CcdInterestDateType.CUSTOM)
            .interestClaimStartDate(LocalDate.now())
            .interestSpecificDailyAmount(BigDecimal.valueOf(10))
            .interestEndDateType(CcdInterestEndDateType.SUBMISSION)
            .paymentStatus("success")
            .paymentDateCreated(LocalDate.of(2019, 01, 01))
            .paymentId("PaymentId")
            .paymentAmount(BigDecimal.valueOf(4000))
            .paymentReference("RC-1524-6488-1670-7520")
            .applicants(claimants)
            .respondents(defendants)
            .timeline(singletonList(CcdCollectionElement.<CcdTimelineEvent>builder()
                .value(CcdTimelineEvent.builder().date("some Date").description("description of event").build())
                .build()))
            .evidence(singletonList(CcdCollectionElement.<CcdEvidenceRow>builder()
                .value(CcdEvidenceRow.builder().type(EXPERT_WITNESS).description("description of evidence").build())
                .build()))
            .build();
    }

}
