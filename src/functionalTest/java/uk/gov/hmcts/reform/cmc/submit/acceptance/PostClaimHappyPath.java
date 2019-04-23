package uk.gov.hmcts.reform.cmc.submit.acceptance;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import uk.gov.hmcts.reform.cmc.submit.BaseTest;
import uk.gov.hmcts.reform.cmc.submit.utils.ResourceReader;

import static org.assertj.core.api.Assertions.assertThat;

public class PostClaimHappyPath extends BaseTest {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("Happy path should create the claim requested in CCD")
    @Test
    public void postClaimHappyPath() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, citizen().getAuthToken());

        String json = new ResourceReader().read("/claim-application.json");
        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        ResponseEntity<String> claimOutput = restTemplate.postForEntity(postClaimEndPoint, entity, String.class);

        assertThat(claimOutput.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED);
    }
}
