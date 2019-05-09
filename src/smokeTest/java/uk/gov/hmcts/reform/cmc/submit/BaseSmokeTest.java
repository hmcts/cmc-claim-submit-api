package uk.gov.hmcts.reform.cmc.submit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import uk.gov.hmcts.reform.idam.client.IdamClient;

import javax.annotation.PostConstruct;

@SpringBootTest
public abstract class BaseSmokeTest {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${cmc.api.submit.url}")
    protected String baseUrl;

    @Value("${cmc.test.smoke.username}")
    protected String citizenUsername;

    @Value("${cmc.test.smoke.password}")
    protected String citizenPassword;

    protected String postClaimEndPoint;
    protected String getClaimEndPoint;

    protected RestTemplate restTemplate;

    @Autowired
    protected IdamClient idamClient;

    @Autowired // httpClient form Feign.
    protected CloseableHttpClient httpClient;

    @PostConstruct
    public void init() {
        getClaimEndPoint = baseUrl + "/claim/{externalIdentifier}";

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        restTemplate = new RestTemplate(requestFactory);

    }

    public String citizenToken() {

        return idamClient.authenticateUser(citizenUsername, citizenPassword);
    }
}
