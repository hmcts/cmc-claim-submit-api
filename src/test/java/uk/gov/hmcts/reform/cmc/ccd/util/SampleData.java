package uk.gov.hmcts.reform.cmc.ccd.util;

import uk.gov.hmcts.cmc.ccd.domain.CCDAddress;
import uk.gov.hmcts.cmc.ccd.domain.CCDAmountRow;
import uk.gov.hmcts.cmc.ccd.domain.CCDCase;
import uk.gov.hmcts.cmc.ccd.domain.CCDClaimant;
import uk.gov.hmcts.cmc.ccd.domain.CCDCollectionElement;
import uk.gov.hmcts.cmc.ccd.domain.CCDInterestDateType;
import uk.gov.hmcts.cmc.ccd.domain.CCDInterestEndDateType;
import uk.gov.hmcts.cmc.ccd.domain.CCDInterestType;
import uk.gov.hmcts.cmc.ccd.domain.CCDTimelineEvent;
import uk.gov.hmcts.cmc.ccd.domain.defendant.CCDDefendant;
import uk.gov.hmcts.cmc.ccd.domain.evidence.CCDEvidenceRow;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static uk.gov.hmcts.cmc.ccd.domain.AmountType.BREAK_DOWN;
import static uk.gov.hmcts.cmc.ccd.domain.AmountType.RANGE;
import static uk.gov.hmcts.cmc.ccd.domain.CCDPartyType.COMPANY;
import static uk.gov.hmcts.cmc.ccd.domain.CCDPartyType.INDIVIDUAL;
import static uk.gov.hmcts.cmc.ccd.domain.CCDPartyType.ORGANISATION;
import static uk.gov.hmcts.cmc.ccd.domain.CCDPartyType.SOLE_TRADER;
import static uk.gov.hmcts.cmc.ccd.domain.evidence.CCDEvidenceType.EXPERT_WITNESS;
import static uk.gov.hmcts.cmc.domain.models.particulars.DamagesExpectation.MORE_THAN_THOUSAND_POUNDS;
import static uk.gov.hmcts.cmc.domain.models.particulars.DamagesExpectation.THOUSAND_POUNDS_OR_LESS;

public class SampleData {

    //Utility class
    private SampleData() {
    }

    public static List<CCDCollectionElement<CCDAmountRow>> getAmountBreakDown() {
        return singletonList(CCDCollectionElement.<CCDAmountRow>builder().value(CCDAmountRow.builder()
            .amount(BigDecimal.valueOf(50))
            .reason("payment")
            .build()).build());
    }

    public static CCDAddress getCcdAddress() {
        return CCDAddress.builder()
            .addressLine1("line1")
            .addressLine2("line2")
            .addressLine3("line3")
            .postTown("city")
            .postCode("postcode")
            .build();
    }

    public static CCDDefendant getCcdDefendantIndividual() {
        CCDAddress ccdAddress = getCcdAddress();
        return CCDDefendant.builder()
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

    public static CCDDefendant getCcdDefendantOrganisation() {
        CCDAddress ccdAddress = getCcdAddress();
        return CCDDefendant.builder()
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

    public static CCDDefendant getCcdDefendantCompany() {
        CCDAddress ccdAddress = getCcdAddress();
        return CCDDefendant.builder()
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

    public static CCDDefendant getCcdDefendantSoleTrader() {
        CCDAddress ccdAddress = getCcdAddress();
        return CCDDefendant.builder()
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

    public static CCDClaimant getCcdClaimantIndividual() {
        CCDAddress ccdAddress = getCcdAddress();
        return CCDClaimant.builder()
            .partyType(INDIVIDUAL)
            .partyAddress(ccdAddress)
            .partyName("Individual")
            .partyPhone("07987654321")
            .partyDateOfBirth(LocalDate.of(1950, 01, 01))
            .partyCorrespondenceAddress(ccdAddress)
            .representativeOrganisationAddress(ccdAddress)
            .representativeOrganisationName("My Org")
            .representativeOrganisationPhone("07987654321")
            .representativeOrganisationEmail("my@email.com")
            .representativeOrganisationDxAddress("dx123")
            .build();
    }

    public static CCDClaimant getCcdClaimantCompany() {
        CCDAddress ccdAddress = getCcdAddress();

        return CCDClaimant.builder()
            .partyType(COMPANY)
            .partyName("Abc Ltd")
            .partyAddress(ccdAddress)
            .partyPhone("07987654321")
            .partyCorrespondenceAddress(ccdAddress)
            .representativeOrganisationAddress(ccdAddress)
            .representativeOrganisationName("My Org")
            .representativeOrganisationPhone("07987654321")
            .representativeOrganisationEmail("my@email.com")
            .representativeOrganisationDxAddress("dx123")
            .partyContactPerson("MR. Hyde")
            .build();
    }

    public static CCDClaimant getCcdClaimantOrganisation() {
        CCDAddress ccdAddress = getCcdAddress();

        return CCDClaimant.builder()
            .partyType(ORGANISATION)
            .partyName("Xyz & Co")
            .partyAddress(ccdAddress)
            .partyPhone("07987654321")
            .partyCorrespondenceAddress(ccdAddress)
            .representativeOrganisationAddress(ccdAddress)
            .representativeOrganisationName("My Org")
            .representativeOrganisationPhone("07987654321")
            .representativeOrganisationEmail("my@email.com")
            .representativeOrganisationDxAddress("dx123")
            .partyContactPerson("MR. Hyde")
            .partyCompaniesHouseNumber("12345678")
            .build();
    }

    public static CCDClaimant getCcdClaimantSoleTrader() {
        CCDAddress ccdAddress = getCcdAddress();

        return CCDClaimant.builder()
            .partyType(SOLE_TRADER)
            .partyTitle("Mr.")
            .partyName("Individual")
            .partyBusinessName("My Trade")
            .partyPhone("07987654321")
            .partyAddress(ccdAddress)
            .partyCorrespondenceAddress(ccdAddress)
            .representativeOrganisationAddress(ccdAddress)
            .representativeOrganisationName("My Org")
            .representativeOrganisationPhone("07987654321")
            .representativeOrganisationEmail("my@email.com")
            .representativeOrganisationDxAddress("dx123")
            .build();
    }

    public static CCDCase getCcdLegalCase() {
        List<CCDCollectionElement<CCDClaimant>> claimants
            = singletonList(CCDCollectionElement.<CCDClaimant>builder().value(getCcdClaimantIndividual()).build());
        List<CCDCollectionElement<CCDDefendant>> defendants
            = singletonList(CCDCollectionElement.<CCDDefendant>builder().value(getCcdDefendantIndividual()).build());
        return CCDCase.builder()
            .id(1L)
            .referenceNumber("ref no")
            .externalId(UUID.randomUUID().toString())
            .amountType(RANGE)
            .amountLowerValue(BigDecimal.valueOf(50))
            .amountHigherValue(BigDecimal.valueOf(500))
            .housingDisrepairCostOfRepairDamages(MORE_THAN_THOUSAND_POUNDS.name())
            .housingDisrepairOtherDamages(THOUSAND_POUNDS_OR_LESS.name())
            .personalInjuryGeneralDamages(MORE_THAN_THOUSAND_POUNDS.name())
            .sotSignerName("name")
            .sotSignerRole("role")
            .externalReferenceNumber("external ref")
            .externalId(UUID.randomUUID().toString())
            .feeAccountNumber("PBA1234567")
            .feeCode("X1202")
            .reason("Reason for the case")
            .preferredCourt("London Court")
            .claimants(claimants)
            .defendants(defendants)
            .build();
    }

    public static CCDCase getCcdCitizenCase(List<CCDCollectionElement<CCDAmountRow>> amountBreakDown) {
        List<CCDCollectionElement<CCDClaimant>> claimants
            = singletonList(CCDCollectionElement.<CCDClaimant>builder().value(getCcdClaimantIndividual()).build());
        List<CCDCollectionElement<CCDDefendant>> defendants
            = singletonList(CCDCollectionElement.<CCDDefendant>builder().value(getCcdDefendantIndividual()).build());

        return CCDCase.builder()
            .id(1l)
            .referenceNumber("ref no")
            .externalId(UUID.randomUUID().toString())
            .amountType(BREAK_DOWN)
            .amountBreakDown(amountBreakDown)
            .housingDisrepairCostOfRepairDamages(MORE_THAN_THOUSAND_POUNDS.name())
            .housingDisrepairOtherDamages(THOUSAND_POUNDS_OR_LESS.name())
            .personalInjuryGeneralDamages(MORE_THAN_THOUSAND_POUNDS.name())
            .sotSignerName("name")
            .sotSignerRole("role")
            .externalReferenceNumber("external ref")
            .externalId(UUID.randomUUID().toString())
            .feeCode("X1202")
            .feeAmountInPennies(BigInteger.valueOf(100))
            .reason("Reason for the case")
            .preferredCourt("London Court")
            .interestType(CCDInterestType.DIFFERENT)
            .interestReason("reason")
            .interestRate(BigDecimal.valueOf(2))
            .interestBreakDownAmount(BigDecimal.valueOf(210))
            .interestBreakDownExplanation("Explanation")
            .interestStartDateReason("start date reason")
            .interestDateType(CCDInterestDateType.CUSTOM)
            .interestClaimStartDate(LocalDate.now())
            .interestSpecificDailyAmount(BigDecimal.valueOf(10))
            .interestEndDateType(CCDInterestEndDateType.SUBMISSION)
            .paymentStatus("success")
            .paymentDateCreated(LocalDate.of(2019, 01, 01))
            .paymentId("PaymentId")
            .paymentAmount(BigDecimal.valueOf(4000))
            .paymentReference("RC-1524-6488-1670-7520")
            .claimants(claimants)
            .defendants(defendants)
            .timeline(singletonList(CCDCollectionElement.<CCDTimelineEvent>builder()
                .value(CCDTimelineEvent.builder().date("some Date").description("description of event").build())
                .build()))
            .evidence(singletonList(CCDCollectionElement.<CCDEvidenceRow>builder()
                .value(CCDEvidenceRow.builder().type(EXPERT_WITNESS).description("description of evidence").build())
                .build()))
            .build();
    }

}
