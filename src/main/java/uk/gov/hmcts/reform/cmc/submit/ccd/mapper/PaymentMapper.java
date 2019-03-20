package uk.gov.hmcts.reform.cmc.submit.ccd.mapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import uk.gov.hmcts.cmc.ccd.domain.CCDCase;
import uk.gov.hmcts.cmc.domain.models.payment.Payment;
import uk.gov.hmcts.reform.cmc.domain.utils.LocalDateTimeFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
public class PaymentMapper implements BuilderMapper<CCDCase, Payment, CCDCase.CCDCaseBuilder> {

    @Override
    public void to(Payment payment, CCDCase.CCDCaseBuilder builder) {
        if (payment == null) {
            return;
        }

        builder
            .paymentAmount(payment.getAmount())
            .paymentId(payment.getId())
            .paymentReference(payment.getReference())
            .paymentStatus(payment.getStatus());

        if (StringUtils.isNotBlank(payment.getDateCreated())) {
            builder.paymentDateCreated(parseDate(payment.getDateCreated()));
        }
    }

    @Override
    public Payment from(CCDCase ccdCase) {
        if (isBlank(ccdCase.getPaymentId())
            && ccdCase.getPaymentAmount() == null
            && isBlank(ccdCase.getPaymentReference())
            && ccdCase.getPaymentDateCreated() == null
            && isBlank(ccdCase.getPaymentStatus())
        ) {
            return null;
        }

        return new Payment(
            ccdCase.getPaymentId(),
            ccdCase.getPaymentAmount(),
            ccdCase.getPaymentReference(),
            ccdCase.getPaymentDateCreated() != null ? ccdCase.getPaymentDateCreated().format(ISO_DATE) : null,
            ccdCase.getPaymentStatus()
        );
    }

    private LocalDate parseDate(String input) {
        try {
            return LocalDate.parse(input, ISO_DATE);
        } catch (DateTimeParseException e) {
            return LocalDateTimeFactory.fromLong(Long.valueOf(input));
        }
    }
}