package uk.gov.hmcts.reform.cmc.ccd.mapper;

import org.junit.Test;

import uk.gov.hmcts.cmc.ccd.domain.CCDCase;
import uk.gov.hmcts.cmc.domain.models.payment.Payment;
import uk.gov.hmcts.reform.cmc.ccd.builders.SamplePayment;
import uk.gov.hmcts.reform.cmc.domain.utils.LocalDateTimeFactory;
import uk.gov.hmcts.reform.cmc.submit.ccd.mapper.PaymentMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentMapperTest {

    private PaymentMapper mapper = new PaymentMapper();

    @Test
    public void shouldMapPaymentToCcd() {
        //given
        Payment payment = SamplePayment.builder().build();

        //when
        CCDCase.CCDCaseBuilder caseBuilder = CCDCase.builder();
        mapper.to(payment, caseBuilder);
        CCDCase ccdCase = caseBuilder.build();

        //then
        assertThat(LocalDate.parse(payment.getDateCreated(), ISO_DATE))
            .isEqualTo(ccdCase.getPaymentDateCreated());
        assertThat(payment.getId()).isEqualTo(ccdCase.getPaymentId());
        assertThat(payment.getAmount()).isEqualTo(ccdCase.getPaymentAmount());
        assertThat(payment.getReference()).isEqualTo(ccdCase.getPaymentReference());
        assertThat(payment.getStatus()).isEqualTo(ccdCase.getPaymentStatus());
    }

    @Test
    public void shouldMapPaymentToCcdWhenNoCreatedDateProvided() {
        //given
        Payment payment = SamplePayment.builder().dateCreated(null).build();

        //when
        CCDCase.CCDCaseBuilder caseBuilder = CCDCase.builder();
        mapper.to(payment, caseBuilder);
        CCDCase ccdCase = caseBuilder.build();

        //then
        assertThat(ccdCase.getPaymentDateCreated()).isNull();
        assertThat(payment.getId()).isEqualTo(ccdCase.getPaymentId());
        assertThat(payment.getAmount()).isEqualTo(ccdCase.getPaymentAmount());
        assertThat(payment.getReference()).isEqualTo(ccdCase.getPaymentReference());
        assertThat(payment.getStatus()).isEqualTo(ccdCase.getPaymentStatus());
    }

    @Test
    public void shouldMapPaymentToCcdWhenLongCreatedDateProvided() {
        //given
        Payment payment = SamplePayment.builder().dateCreated("1511169381890").build();

        //when
        CCDCase.CCDCaseBuilder caseBuilder = CCDCase.builder();
        mapper.to(payment, caseBuilder);
        CCDCase ccdCase = caseBuilder.build();

        //then
        assertThat(LocalDateTimeFactory.fromLong(Long.valueOf(payment.getDateCreated())))
            .isEqualTo(ccdCase.getPaymentDateCreated());
        assertThat(payment.getId()).isEqualTo(ccdCase.getPaymentId());
        assertThat(payment.getAmount()).isEqualTo(ccdCase.getPaymentAmount());
        assertThat(payment.getReference()).isEqualTo(ccdCase.getPaymentReference());
        assertThat(payment.getStatus()).isEqualTo(ccdCase.getPaymentStatus());
    }

    @Test
    public void shouldMapPaymentFromCcd() {
        //given
        CCDCase ccdCase = CCDCase.builder()
            .paymentAmount(BigDecimal.valueOf(4000))
            .paymentReference("RC-1524-6488-1670-7520")
            .paymentId("PaymentId")
            .paymentStatus("success")
            .paymentDateCreated(LocalDate.of(2019, 01, 01))
            .build();

        //when
        Payment payment = mapper.from(ccdCase);

        //then
        assertThat(LocalDate.parse(payment.getDateCreated(), ISO_DATE))
            .isEqualTo(ccdCase.getPaymentDateCreated());
        assertThat(payment.getId()).isEqualTo(ccdCase.getPaymentId());
        assertThat(payment.getAmount()).isEqualTo(ccdCase.getPaymentAmount());
        assertThat(payment.getReference()).isEqualTo(ccdCase.getPaymentReference());
        assertThat(payment.getStatus()).isEqualTo(ccdCase.getPaymentStatus());
    }

    @Test
    public void shouldMapPaymentFromCcdWhenNoDateCreatedProvided() {
        //given
        CCDCase ccdCase = CCDCase.builder()
            .paymentAmount(BigDecimal.valueOf(4000))
            .paymentReference("RC-1524-6488-1670-7520")
            .paymentId("PaymentId")
            .paymentStatus("success")
            .paymentDateCreated(null)
            .build();

        //when
        Payment payment = mapper.from(ccdCase);

        //then
        assertThat(payment.getDateCreated()).isBlank();
        assertThat(payment.getId()).isEqualTo(ccdCase.getPaymentId());
        assertThat(payment.getAmount()).isEqualTo(ccdCase.getPaymentAmount());
        assertThat(payment.getReference()).isEqualTo(ccdCase.getPaymentReference());
        assertThat(payment.getStatus()).isEqualTo(ccdCase.getPaymentStatus());
    }
}
