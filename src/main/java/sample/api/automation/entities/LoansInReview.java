package sample.api.automation.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoansInReview {
    private String firstName;

    public String getfirstName() {
        return firstName;
    }

    
    private String productType;
    
    public String getProductType() {
        return productType;
    }
    
    @SuppressWarnings("unchecked")
    @JsonProperty("resources")
    private void unmarshallNested(Map<String, Object> resources){
        Map<String, String> loansInReview = (Map<String, String>) resources.get("loansInReview");
        productType = loansInReview.get("productType");
    }
}
