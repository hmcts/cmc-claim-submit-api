package uk.gov.hmcts.reform.cmc.ccd.mapper;

import org.junit.Test;

import uk.gov.hmcts.cmc.ccd.domain.CCDCollectionElement;
import uk.gov.hmcts.cmc.ccd.domain.evidence.CCDEvidenceRow;
import uk.gov.hmcts.cmc.ccd.domain.evidence.CCDEvidenceType;
import uk.gov.hmcts.cmc.domain.models.evidence.EvidenceRow;
import uk.gov.hmcts.reform.cmc.submit.ccd.mapper.EvidenceRowMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.models.evidence.EvidenceType.CORRESPONDENCE;
import static uk.gov.hmcts.reform.cmc.ccd.assertion.Assertions.assertThat;

public class EvidenceRowMapperTest {

    private EvidenceRowMapper mapper = new EvidenceRowMapper();

    @Test
    public void shouldMapEvidenceRowToCcd() {
        //given
        EvidenceRow evidenceRow = EvidenceRow.builder().type(CORRESPONDENCE).description("description").build();

        //when
        CCDCollectionElement<CCDEvidenceRow> ccdEvidenceRow = mapper.to(evidenceRow);

        //then
        assertThat(evidenceRow).isEqualTo(ccdEvidenceRow.getValue());
        assertThat(evidenceRow.getId()).isEqualTo(ccdEvidenceRow.getId());
    }

    @Test
    public void shouldMapEvidenceRowToCcdWhenNoDescriptionProvided() {
        //given
        EvidenceRow evidenceRow = EvidenceRow.builder().type(CORRESPONDENCE).description(null).build();

        //when
        CCDCollectionElement<CCDEvidenceRow> ccdEvidenceRow = mapper.to(evidenceRow);

        //then
        assertThat(evidenceRow).isEqualTo(ccdEvidenceRow.getValue());
        assertThat(evidenceRow.getId()).isEqualTo(ccdEvidenceRow.getId());
    }

    @Test
    public void shouldMapEvidenceRowFromCcd() {
        //given
        CCDEvidenceRow ccdEvidenceRow = CCDEvidenceRow.builder()
            .description("My description")
            .type(CCDEvidenceType.EXPERT_WITNESS)
            .build();

        //when
        EvidenceRow evidenceRow = mapper.from(CCDCollectionElement.<CCDEvidenceRow>builder()
            .value(ccdEvidenceRow).build());

        //then
        assertThat(evidenceRow).isEqualTo(ccdEvidenceRow);
    }

    @Test
    public void shouldMapEvidenceRowFromCcdWhenNoDescriptionProvided() {
        //given
        CCDEvidenceRow ccdEvidenceRow = CCDEvidenceRow.builder()
            .type(CCDEvidenceType.EXPERT_WITNESS)
            .build();

        //when
        EvidenceRow evidenceRow = mapper.from(CCDCollectionElement.<CCDEvidenceRow>builder()
            .value(ccdEvidenceRow).build());

        //then
        assertThat(evidenceRow).isEqualTo(ccdEvidenceRow);
    }
}