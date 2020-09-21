package sample.api.automation.tests;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetEndpointResponseTest extends BaseClass {

    @Test()
    public void createRepoReturns200()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + "secretEndpoint");

        request.setHeader("x-cf-source-id", "privacy");
        request.setHeader("x-cf-corr-id", "privacy");
        request.setHeader("Content-Type", "application/json");
        
        String json = "{\"username\":\"privacy\",\"password\":\"privacy\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }
    
    @Test()
    public void createRepoReturns401()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + "secretEndpoint");

        request.setHeader("x-cf-source-id", "privacy");
        request.setHeader("x-cf-corr-id", "privacy");
        request.setHeader("Content-Type", "application/json");
        
        String json = "{\"username\":\"privacy\",\"password\":\"privacy\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 401);
    }
}
