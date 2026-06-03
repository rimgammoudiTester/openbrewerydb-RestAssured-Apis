package configReader;

import enums.environment.EnvironmentUrls;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class EnvironmentReader {
    private static final Log log = LogFactory.getLog(EnvironmentReader.class);
    /**
     * @Author Rim Gammoudi
     */

    public static String currentEnvironment;

//Method used to read the enumEnvironmentUrls

    public static String readEnumUrls() {
        log.info("Reading the environment ");
        String targetEnv = System.getProperty("env", "DEV").toUpperCase();
        try {

            EnvironmentUrls environmentUrl = EnvironmentUrls.valueOf(targetEnv);
            currentEnvironment = environmentUrl.getUrl();

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("The environment you've entered is wrong");
        }
        return currentEnvironment;
    }
}
