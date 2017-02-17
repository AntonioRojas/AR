package utilitiesAcceptance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * 
 * @author Antonio Rojas
 * @version 1.0
 * @date 2/10/2017
 * 
 */

public class ReadConfigFile {
    private static final Logger logger = Logger.getLogger(ReadConfigFile.class.getName());
    private final static String configFile = "config/properties.xml";
    private static String TCATURL = init().getProperty("tomcat.url");
    private static String TCATPORT = init().getProperty("tomcat.port");
    
    /**
     * 
     * @return the property value requested
     */
    private static Properties init(){
        Properties props = new Properties();
        
        InputStream is = null;
        try {
            is = new FileInputStream(configFile);
        } catch (FileNotFoundException ex) {
            logger.fatal("File for properties was not found, error: " + ex.toString());
        }
        try {
            //load the xml file into properties format
            props.loadFromXML(is);
        } catch (IOException ex) {
            logger.fatal("We were not able to load the XML file, error: " + ex.toString());
        }
        return props;
    }

	public static String getTCATURL() {
		return TCATURL;
	}

	public static String getTCATPORT() {
		return TCATPORT;
	}

}
