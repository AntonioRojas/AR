package test.java;

import java.io.IOException;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.crunchify.restjersey.CtoFService;
import com.crunchify.restjersey.FtoCService;


/**
 * This class was created to do some integration test with Tomcat
 * Date 2/3/2017 
 * @author Antonio Rojas
 * version 1.0
 */
public class restUnitTest {
	final static Logger logger = Logger.getLogger(restUnitTest.class);
	CtoFService ctf = new CtoFService();
	FtoCService ftc = new FtoCService();

    @Test
    public void testconvertCtoF() throws IOException{
    	// Given
    	String result;
        //When
    	result = ctf.convertCtoF();
    	logger.info(result);
        //Then
        Assert.assertTrue(result.contains("@Produces(\"application/xml\")"), "Expected output is not correct: " + result);
    }
    
    @Test
    public void testconvertCtoFfromInput() throws IOException{
    	// Given
    	String result;
        //When
    	result = ctf.convertCtoFfromInput(34.0);
    	logger.info(result);
        //Then
    	Assert.assertTrue(result.contains("@Produces(\"application/xml\")"), "Expected output is not correct: " + result);
    }
    
    @Test
    public void testconvertFtoC() throws IOException{
    	// Given
    	Response result;
    	//When
    	result = ftc.convertFtoC();
    	logger.info(result.getEntity());
    	//Then
    	Assert.assertNotNull(result.getEntity());
    	Assert.assertTrue(result.getStatus()==200, "Expected error is not correct: " + result.getEntity());
    }
    
    @Test
    public void testconvertFtoCfromInput() throws IOException{
    	// Given
    	Response result;
    	//When
    	result = ftc.convertFtoCfromInput(89);
    	logger.info(result.getEntity());
    	//Then
    	Assert.assertNotNull(result.getEntity());
    	Assert.assertTrue(result.getStatus()==200, "Expected error is not correct: " + result.getEntity());
    }

}
