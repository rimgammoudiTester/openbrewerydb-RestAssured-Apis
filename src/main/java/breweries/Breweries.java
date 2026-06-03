package breweries;

import io.restassured.response.Response;
import keywordActions.keywordApi.GenericApiCalls;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

public class Breweries extends GenericApiCalls {

    private static final Log log = LogFactory.getLog(Breweries.class);

    /**
     * @Author Rim Gammoudi
     */

    public Breweries() {
        super();
    }

    //Method useful to recuperate Objects by query
    public Response recuperateBreweriesByQuery(String endpoint, HashMap<String, Object> breweriesQuery, HashMap<String, String> headersMap) {
     log.info("Fetching  the list of breweries depending on the query passed : ");
        return getCallWithQueryParam(endpoint, breweriesQuery,headersMap);
    }

    //Method useful to recuperate Objects without params <get list of breweries>
    public Response recuperateBreweries(String endpoint) {
        log.info("Fetching  the list of breweries :");
        return getCallWithoutParams(endpoint);
    }

}
