package stepDefinitions;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilitiesAcceptance.ReadConfigFile;



public class Selenium {
	final static Logger logger = Logger.getLogger(Selenium.class);
	static WebDriver driver;
	private String tomcatURL = ReadConfigFile.getTCATURL() + ":" + ReadConfigFile.getTCATPORT();
	
	public Selenium(){
		System.setProperty("webdriver.chrome.driver","C:\\Ruby23-x64\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	public void openWebPage(){
		driver.get(tomcatURL+"/CrunchifyRESTJerseyExample/");
	}
	
	public void clickLink(String linkText){
		driver.findElement(By.linkText(linkText)).click();
	}
	
	public boolean checkOutput(int statusCode) throws ClientProtocolException, IOException{
		driver.getCurrentUrl();
		
		HttpUriRequest request = new HttpGet(driver.getCurrentUrl());

    	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
    	
    	if (httpResponse.getStatusLine().getStatusCode()==statusCode){
    		driver.close();
    		return true;
    	}
    	else{
    		driver.close();
    		return false;
    	}
	}

}
