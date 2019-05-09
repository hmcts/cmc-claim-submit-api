package uk.gov.hmcts.reform.cmc.submit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Autowired
    protected IdamClient idamClient;

    @PostConstruct
    public void init() {
        getClaimEndPoint = baseUrl + "/claim/{externalIdentifier}";
    }

    public String citizenToken() {

        log.info(citizenUsername + " : " + citizenPassword);
        return idamClient.authenticateUser(citizenUsername, citizenPassword);
    }
}
