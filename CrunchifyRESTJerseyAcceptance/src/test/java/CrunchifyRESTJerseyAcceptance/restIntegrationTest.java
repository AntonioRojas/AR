package CrunchifyRESTJerseyAcceptance;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilitiesAcceptance.ReadConfigurationFile;


/**
 * This class was created to do some integration test with Tomcat
 * Date 2/3/2017 
 * @author Antonio Rojas
 * version 1.0
 */
public class restIntegrationTest {
	final static Logger logger = Logger.getLogger(restIntegrationTest.class);
	private String tomcatURL = ReadConfigurationFile.getTCATURL() + ":" + ReadConfigurationFile.getTCATPORT();

    @Test
    public void testGetProducts() throws IOException{
    	// Given
        HttpURLConnection http = (HttpURLConnection)new URL(tomcatURL+"/CrunchifyRESTJerseyExample/").openConnection();
        //When
        http.connect();
        //Then
        logger.info(http.getResponseCode());
        Assert.assertEquals(http.getResponseCode(), 200, "Expected code is not 200");
    }
    
    @Test
    public void testRamdomCelcius() throws IOException{
    	// Given
    	String celcious = String.valueOf(Math.random());
    	HttpUriRequest request = new HttpGet(tomcatURL+"/CrunchifyRESTJerseyExample/crunchify/ctofservice/" + celcious );
    	// When
    	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
    	// Then
    	Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200, "Expected code is not 200");
    }

}
