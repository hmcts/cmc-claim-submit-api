package uk.gov.hmcts.reform.cmc.submit.ccd.domain;

import lombok.Data;

@Data
public class CcdApplicant {
    private CcdParty partyDetail;
    private String partyName;
    private String representativeOrganisationName;
    private CcdAddress representativeOrganisationAddress;
    private String representativeOrganisationPhone;
    private String representativeOrganisationEmail;
    private String representativeOrganisationDxAddress;
}

