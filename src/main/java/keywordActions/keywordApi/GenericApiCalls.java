package keywordActions.keywordApi;

import configReader.EnvironmentReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

public class GenericApiCalls {

    public static final Log log = LogFactory.getLog(GenericApiCalls.class);
    /**
     * @Author Rim Gammoudi**
     */
    RequestSpecification req;
    EnvironmentReader environmentReader;

    //Method useful to intialize the baseURl of api
    public RequestSpecification intializeTheUri(HashMap<String, String> headersMap) {
        log.info("intializing the environment value and getting the adequat url");
        return req = RestAssured.given().baseUri(EnvironmentReader.readEnumUrls()).headers(headersMap);

    }


    //method useful to perform a get Call
    public Response getCallWithoutParams(String endPoint) {

        return req.when().get(endPoint).then().extract().response();


    }

    //method useful to perform a get Call with queryParams

    public Response getCallWithQueryParam(String endPoint, HashMap<String, Object> QueryParam,HashMap<String,String>headersMap) {
     req=intializeTheUri( headersMap);
        return req.when().queryParams(QueryParam).get(endPoint).then().extract().response();
    }

    //method useful to perform a get Call with pathParam

    public Response getCallWithPathParam(String endPoint, Object pathParameter, String parameterName) {

        return req.when().pathParam(parameterName, pathParameter).get(endPoint).then().extract().response();

    }

    //method useful to perform a post Call

    public Response postCall(String endPoint, HashMap<String, Object> payload) {
        return req.when().body(payload).post(endPoint).then().extract().response();


    }


    //method useful to perform an update Call

    public Response updateCall(String endPoint, HashMap<String, Object> payload) {
        return req.when().body(payload).put(endPoint).then().extract().response();


    }

    //method useful to perform a delete Call

    public Response deleteCall(String endPoint, HashMap<String, Object> payload) {
        return req.when().body(payload).delete(endPoint).then().extract().response();
    }


}
