package com.example.ageverifier;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class AgeVerfierBackEnd {

    private Response response;
    private ValidatableResponse json;    
    private String ENDPOINT_AGE_VERIFER = "https://age-verifier.herokuapp.com/age/verifier";


    @Given("^I have a BackendConnection")
    public void I_have_a_MainActivity(){
    }


    @When("I input age (\\S+) json$")
    public void I_input_age (Integer age){

        String payload = "{\n" +
                "  \"age\":" + age +
                "}";
        response = given()
                .body(payload)
                .contentType("application/json")
                .post(ENDPOINT_AGE_VERIFER);        

    }

    @Then("The status code is (\\S+)$")
    public void verify_status_code(int statusCode){
    	json = response.then().statusCode(statusCode);
    	 Assert.assertEquals(statusCode, response.getStatusCode());
    }

    /**
     * asserts on json fields with single values
     */
    @And("I should (\\S+) response$")
    public void response_equals(String isValid){
    	if (!isValid.contains("bug")) {
    		json.body("isValid", equalTo(Boolean.parseBoolean(isValid)));
    	} else if (isValid.equals("bug1")) {
    		json.body("isValid", equalTo(null));
    	} else if (isValid.equals("bug2")) {
    		
    	}
        
    }
}
