package uk.gov.hmcts.reform.cmc.submit.ccd.mapper.defendants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.gov.hmcts.cmc.ccd.domain.CcdCollectionElement;
import uk.gov.hmcts.cmc.ccd.domain.CcdPartyType;
import uk.gov.hmcts.cmc.ccd.domain.defendant.CcdDefendant;
import uk.gov.hmcts.reform.cmc.submit.ccd.mapper.exception.MappingException;
import uk.gov.hmcts.reform.cmc.submit.domain.models.defendants.CompanyDetails;
import uk.gov.hmcts.reform.cmc.submit.domain.models.defendants.IndividualDetails;
import uk.gov.hmcts.reform.cmc.submit.domain.models.defendants.OrganisationDetails;
import uk.gov.hmcts.reform.cmc.submit.domain.models.defendants.SoleTraderDetails;
import uk.gov.hmcts.reform.cmc.submit.domain.models.defendants.TheirDetails;

@Component
public class TheirDetailsMapper {

    private final IndividualDetailsMapper individualDetailsMapper;
    private final CompanyDetailsMapper companyDetailsMapper;
    private final OrganisationDetailsMapper organisationDetailsMapper;
    private final SoleTraderDetailsMapper soleTraderDetailsMapper;

    @Autowired
    public TheirDetailsMapper(
        IndividualDetailsMapper individualDetailsMapper,
        CompanyDetailsMapper companyDetailsMapper,
        OrganisationDetailsMapper organisationDetailsMapper,
        SoleTraderDetailsMapper soleTraderDetailsMapper
    ) {

        this.individualDetailsMapper = individualDetailsMapper;
        this.companyDetailsMapper = companyDetailsMapper;
        this.organisationDetailsMapper = organisationDetailsMapper;
        this.soleTraderDetailsMapper = soleTraderDetailsMapper;
    }

    public void to(CcdDefendant.CcdDefendantBuilder builder, TheirDetails theirDetails) {

        if (theirDetails instanceof IndividualDetails) {
            builder.claimantProvidedType(CcdPartyType.INDIVIDUAL);
            IndividualDetails individual = (IndividualDetails) theirDetails;
            individualDetailsMapper.to(individual, builder);
        } else if (theirDetails instanceof CompanyDetails) {
            builder.claimantProvidedType(CcdPartyType.COMPANY);
            CompanyDetails company = (CompanyDetails) theirDetails;
            companyDetailsMapper.to(company, builder);
        } else if (theirDetails instanceof OrganisationDetails) {
            builder.claimantProvidedType(CcdPartyType.ORGANISATION);
            OrganisationDetails organisation = (OrganisationDetails) theirDetails;
            organisationDetailsMapper.to(organisation, builder);
        } else if (theirDetails instanceof SoleTraderDetails) {
            builder.claimantProvidedType(CcdPartyType.SOLE_TRADER);
            SoleTraderDetails soleTrader = (SoleTraderDetails) theirDetails;
            soleTraderDetailsMapper.to(soleTrader, builder);
        }
    }

    public TheirDetails from(CcdCollectionElement<CcdDefendant> ccdDefendant) {
        switch (ccdDefendant.getValue().getClaimantProvidedType()) {
            case COMPANY:
                return companyDetailsMapper.from(ccdDefendant);
            case INDIVIDUAL:
                return individualDetailsMapper.from(ccdDefendant);
            case SOLE_TRADER:
                return soleTraderDetailsMapper.from(ccdDefendant);
            case ORGANISATION:
                return organisationDetailsMapper.from(ccdDefendant);
            default:
                throw new MappingException("Invalid defendant type, "
                    + ccdDefendant.getValue().getClaimantProvidedType());
        }
    }
}
