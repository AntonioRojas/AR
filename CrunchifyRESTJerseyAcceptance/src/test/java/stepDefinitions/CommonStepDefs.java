package stepDefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonStepDefs {
	final static Logger logger = Logger.getLogger(CommonStepDefs.class);
	Selenium sel = new Selenium();
	
	@Given("^user opens Crunchify web page$")
	public void user_opens_Crunchify_web_page() throws Throwable {
	    sel.openWebPage();
	}
	
	@When("^user clicks on c to f links$")
	public void user_clicks_on_c_to_f_links() throws Throwable {
	    sel.clickLink("Celsius to Fahrenheit web service without parameter");
	}
	
	@When("^user clicks on c to f links with parameters$")
	public void user_clicks_on_c_to_f_links_with_parameters() throws Throwable {
	    sel.clickLink("Celsius to Fahrenheit web service with parameters");
	}

	@Then("^output message showing c into f is displayed$")
	public void output_message_showing_c_into_f_is_displayed() throws Throwable {
		Assert.assertTrue(sel.checkOutput(200));
	}
	
	@When("^user clicks on f to c links$")
	public void user_clicks_on_f_to_c_links() throws Throwable {
	    sel.clickLink("Fahrenheit to Celsius web service without parameters");
	}
	
	@When("^user clicks on f to c links with parameters$")
	public void user_clicks_on_f_to_c_links_with_parameters() throws Throwable {
	    sel.clickLink("Fahrenheit to Celsius web service with parameters");
	}

	@Then("^output message showing f into c is displayed$")
	public void output_message_showing_f_into_c_is_displayed() throws Throwable {
		Assert.assertTrue(sel.checkOutput(200));
	}
}
