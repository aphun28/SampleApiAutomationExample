package sample.api.automation.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import sample.api.automation.ResponseUtils;
import sample.api.automation.entities.LoansInReview;

public class GetResponseValidationTest extends BaseClass{
	@Test
	public void createResponseReturns() throws IOException {
		HttpPost request = new HttpPost(BASE_ENDPOINT + "/api/brportorch/v2/login");

		request.setHeader("x-cf-source-id", "privacy");
        request.setHeader("x-cf-corr-id", "privacy");
        request.setHeader("Content-Type", "application/json");
        
        String json = "{\"username\":\"privacy\",\"password\":\"privacy\"}";

		request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
		response = client.execute(request);

		LoansInReview loanInReview = ResponseUtils.unmarshallGeneric(response, LoansInReview.class);
		assertEquals(loanInReview.getProductType(), "PERSONAL LOAN");
	}
}
