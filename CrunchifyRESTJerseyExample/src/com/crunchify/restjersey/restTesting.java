package com.crunchify.restjersey;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

/**
 * This class was created to do some unit test via Junit
 * Date 2/3/2017 
 * @author Antonio Rojas
 * version 1.0
 */
public class restTesting {


    @Test
    public void testGetProducts() throws IOException{
    	// Given
        HttpURLConnection http = (HttpURLConnection)new URL("http://localhost:8080/CrunchifyRESTJerseyExample/").openConnection();
        //When
        http.connect();
        //Then
        assertEquals(http.getResponseCode(), 200);
    }
    
    @Test
    public void testRamdomCelcius() throws IOException{
    	// Given
    	String celcious = String.valueOf(Math.random());
    	HttpUriRequest request = new HttpGet( "http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/ctofservice/" + celcious );
    	// When
    	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
    	// Then
    	assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
    }

}
