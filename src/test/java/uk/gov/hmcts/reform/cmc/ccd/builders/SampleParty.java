package uk.gov.hmcts.reform.cmc.ccd.builders;

import uk.gov.hmcts.cmc.domain.models.claimants.Company;
import uk.gov.hmcts.cmc.domain.models.claimants.Individual;
import uk.gov.hmcts.cmc.domain.models.claimants.Organisation;
import uk.gov.hmcts.cmc.domain.models.claimants.Party;
import uk.gov.hmcts.cmc.domain.models.claimants.SoleTrader;
import uk.gov.hmcts.cmc.domain.models.common.Address;
import uk.gov.hmcts.cmc.domain.models.common.Representative;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SampleParty {

    private String name = "John Rambo";
    private String businessName = "Trading as name";
    private String contactPerson = "Steven Seagal";
    private Address address = SampleAddress.builder().build();
    private Address correspondenceAddress = SampleAddress.builder().build();
    private String title = "Dr.";
    private String mobilePhone = "07873727165";
    private LocalDate dateOfBirth = LocalDate.of(1968, 1, 2);
    private Representative representative = SampleRepresentative.builder().build();
    private String companiesHouseNumber;
    private String collectionId = "acd82549-d279-4adc-b38c-d195dd0db0d6";

    public static SampleParty builder() {
        return new SampleParty();
    }

    public SampleParty withName(String name) {
        this.name = name;
        return this;
    }

    public SampleParty withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public SampleParty withContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public SampleParty withBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public SampleParty withAddress(Address address) {
        this.address = address;
        return this;
    }

    public SampleParty withCorrespondenceAddress(Address correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
        return this;
    }

    public SampleParty withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public SampleParty withRepresentative(Representative representative) {
        this.representative = representative;
        return this;
    }

    public SampleParty withTitle(String title) {
        this.title = title;
        return this;
    }

    public SampleParty withCompaniesHouseNumber(String companiesHouseNumber) {
        this.companiesHouseNumber = companiesHouseNumber;
        return this;
    }

    public SampleParty withCollectionId(String collectionId) {
        this.collectionId = collectionId;
        return this;
    }

    public Party party() {
        return new Individual(collectionId, name, address, correspondenceAddress, mobilePhone,
            representative, dateOfBirth);
    }

    public Individual individual() {
        return new Individual(collectionId, name, address, correspondenceAddress, mobilePhone,
            representative, dateOfBirth);
    }

    public List<Party> individualDetails(int count) {
        List<Party> individualDetailsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            individualDetailsList.add(
                new Individual(collectionId, name, address, correspondenceAddress, mobilePhone,
                    representative, dateOfBirth)
            );
        }
        return individualDetailsList;
    }

    public SoleTrader soleTrader() {
        return new SoleTrader(collectionId, name, address, correspondenceAddress, mobilePhone,
            representative, title, businessName);
    }

    public Company company() {
        return new Company(collectionId, name, address, correspondenceAddress, mobilePhone,
            representative, contactPerson);
    }

    public Organisation organisation() {
        return new Organisation(collectionId, name, address, correspondenceAddress, mobilePhone,
            representative, contactPerson, companiesHouseNumber);
    }
}