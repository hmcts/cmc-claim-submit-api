package uk.gov.hmcts.reform.cmc.submit.services;


import uk.gov.hmcts.reform.cmc.submit.domain.models.Claim;
import uk.gov.hmcts.reform.cmc.submit.domain.models.ClaimInput;
import uk.gov.hmcts.reform.cmc.submit.domain.models.ClaimOutput;
import uk.gov.hmcts.reform.cmc.submit.exception.ApplicationException;

public interface ClaimService {

    Claim getClaim(String externalIdentifier) throws ApplicationException;

    ClaimOutput createNewCase(ClaimInput claimData) throws ApplicationException;

}
