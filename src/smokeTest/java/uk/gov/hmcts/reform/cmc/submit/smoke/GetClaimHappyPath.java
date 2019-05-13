package uk.gov.hmcts.reform.cmc.submit.smoke;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import uk.gov.hmcts.reform.cmc.submit.BaseSmokeTest;

import static org.assertj.core.api.Assertions.assertThat;

public class GetClaimHappyPath extends BaseSmokeTest {

    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("Happy path should return the claim requested in CCD")
    @Test
    public void getClaimHappyPath() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, citizenToken());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> claimOutput = restTemplate.exchange(getClaimEndPoint,
                                                                   HttpMethod.GET,
                                                                   entity,
                                                                   String.class,
                                                                   "test");

        assertThat(claimOutput.getStatusCodeValue()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
