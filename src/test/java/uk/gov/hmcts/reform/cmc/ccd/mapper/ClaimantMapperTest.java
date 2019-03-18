package uk.gov.hmcts.reform.cmc.ccd.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import uk.gov.hmcts.cmc.ccd.domain.CCDClaimant;
import uk.gov.hmcts.cmc.ccd.domain.CCDCollectionElement;
import uk.gov.hmcts.cmc.domain.models.claimants.Party;
import uk.gov.hmcts.reform.cmc.ccd.builders.SampleParty;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.reform.cmc.ccd.assertion.Assertions.assertThat;
import static uk.gov.hmcts.reform.cmc.ccd.util.SampleData.getCcdClaimantCompany;
import static uk.gov.hmcts.reform.cmc.ccd.util.SampleData.getCcdClaimantIndividual;
import static uk.gov.hmcts.reform.cmc.ccd.util.SampleData.getCcdClaimantOrganisation;
import static uk.gov.hmcts.reform.cmc.ccd.util.SampleData.getCcdClaimantSoleTrader;

public class ClaimantMapperTest {

    @Autowired
    private ClaimantMapper claimantMapper = new ClaimantMapper(
                                            new IndividualMapper(new AddressMapper(), new RepresentativeMapper(new AddressMapper(), new ContactDetailsMapper())),
                                            new CompanyMapper(new AddressMapper(), new RepresentativeMapper(new AddressMapper(), new ContactDetailsMapper())),
                                            new OrganisationMapper(new AddressMapper(), new RepresentativeMapper(new AddressMapper(), new ContactDetailsMapper())),
                                            new SoleTraderMapper(new AddressMapper(), new RepresentativeMapper(new AddressMapper(), new ContactDetailsMapper())));

    @Test
    public void shouldMapIndividualToCcd() {
        //given
        Party party = SampleParty.builder().individual();

        //when
        CCDCollectionElement<CCDClaimant> ccdParty = claimantMapper.to(party);
        CCDClaimant ccdClaimant = ccdParty.getValue();

        //then
        assertThat(party).isEqualTo(ccdClaimant);
    }

    @Test
    public void shouldMapCompanyToCcd() {
        //given
        Party party = SampleParty.builder().company();

        //when
        CCDCollectionElement<CCDClaimant> ccdParty = claimantMapper.to(party);
        CCDClaimant ccdClaimant = ccdParty.getValue();

        //then
        assertThat(party).isEqualTo(ccdClaimant);
    }

    @Test
    public void shouldMapOrganisationToCcd() {
        //given
        Party party = SampleParty.builder().organisation();

        //when
        CCDCollectionElement<CCDClaimant> ccdParty = claimantMapper.to(party);
        CCDClaimant ccdClaimant = ccdParty.getValue();

        //then
        assertThat(party).isEqualTo(ccdClaimant);
    }

    @Test
    public void shouldMapSoleTraderToCcd() {
        //given
        Party party = SampleParty.builder().soleTrader();

        //when
        CCDCollectionElement<CCDClaimant> ccdParty = claimantMapper.to(party);
        CCDClaimant ccdClaimant = ccdParty.getValue();

        //then
        assertThat(party).isEqualTo(ccdClaimant);
    }

    @Test
    public void shouldMapIndividualFromCcd() {
        //given
        CCDClaimant ccdParty = getCcdClaimantIndividual();
        String collectionId = UUID.randomUUID().toString();

        //when
        Party party = claimantMapper
            .from(CCDCollectionElement.<CCDClaimant>builder()
                .id(collectionId)
                .value(ccdParty).build());

        //then
        assertThat(party).isEqualTo(ccdParty);
        assertThat(party.getId()).isEqualTo(collectionId);
    }

    @Test
    public void shouldMapCompanyFromCcd() {
        //given
        CCDClaimant ccdParty = getCcdClaimantCompany();
        String collectionId = UUID.randomUUID().toString();

        //when
        Party party = claimantMapper
            .from(CCDCollectionElement.<CCDClaimant>builder()
                .id(collectionId)
                .value(ccdParty).build());

        //then
        assertThat(party).isEqualTo(ccdParty);
        assertThat(party.getId()).isEqualTo(collectionId);
    }

    @Test
    public void shouldMapOrganisationFromCcd() {
        //given
        CCDClaimant ccdParty = getCcdClaimantOrganisation();
        String collectionId = UUID.randomUUID().toString();

        //when
        Party party = claimantMapper
            .from(CCDCollectionElement.<CCDClaimant>builder()
                .id(collectionId)
                .value(ccdParty).build());

        //then
        assertThat(party).isEqualTo(ccdParty);
        assertThat(party.getId()).isEqualTo(collectionId);
    }

    @Test
    public void shouldMapSoleTraderFromCcd() {
        //given
        CCDClaimant ccdParty = getCcdClaimantSoleTrader();
        String collectionId = UUID.randomUUID().toString();

        //when
        Party party = claimantMapper
            .from(CCDCollectionElement.<CCDClaimant>builder()
                .id(collectionId)
                .value(ccdParty).build());

        //then
        assertThat(party).isEqualTo(ccdParty);
        assertThat(party.getId()).isEqualTo(collectionId);
    }

}
