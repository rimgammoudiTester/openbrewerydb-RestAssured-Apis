package apiTests.breweries;

import bases.BaseApi;
import breweries.Breweries;
import io.restassured.response.Response;
import keywordActions.keywordApi.GenericApiCalls;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static configReader.JsonFilerReader.readingTheJsonFile;
import static enums.enumApi.byType.TYPE.*;
import static keywordActions.keyRegister.KeyRegister.*;
import static utilities.statusCode.StatusCode.BadRequestCode;
import static utilities.statusCode.StatusCode.successCode;

public class BreweriesTests extends BaseApi {


    /**
     * @Author Rim Gammoudi
     */
    Breweries breweries;
    GenericApiCalls genericApiCalls;
    HashMap<String, String> headersMap;
    HashMap<String, String> breweriesMap;
    HashMap<String, String> breweriesWrongMap;

    private final String endpoint = "/v1/breweries";

    @BeforeClass()
    public void intialize() {
        String BreweriesJsonFile = "models/apidata/breweriesParam.json";
        String wrongBreweriesJsonFile = "models/apidata/breweriesWithWrongValues.json";
        breweries = new Breweries();
        headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", "application/json");
        genericApiCalls = new GenericApiCalls();
        //genericApiCalls.intializeTheUri(headersMap);
        breweriesMap = readingTheJsonFile(BreweriesJsonFile);
        breweriesWrongMap = readingTheJsonFile(wrongBreweriesJsonFile);

    }


    //Data provider for all query params needed
    @DataProvider
    public Object[][] getQueryParams() {
        return new Object[][]{

                {CITY, breweriesMap.get(CITY)},// query param CITY with the value of it
                {COUNTREY, breweriesMap.get(COUNTREY)},//query param COUNTREY with the value of it
                {NAME, breweriesMap.get(NAME)},//query param NAME with the value of it
                {STATE, breweriesMap.get(STATE)},//query param STATE with the value of it
                {POSTAL_CODE, breweriesMap.get(POSTAL_CODE)},//query param POSTAL_CODE with the value of it
                {PAGE, breweriesMap.get(PAGE)},//query param PAGE with the value of it
                {PER_PAGE, breweriesMap.get(PER_PAGE)},//query param PER_PAGE with the value of it
                {SORT, breweriesMap.get(SORT)},//query param SORT with the value of it
                {IDS, breweriesMap.get(IDS)},//query param IDS with the value of it
                {DIST, breweriesMap.get(DIST)},
                {TYPE, breweriesMap.get(TYPE)},//query param DIST with the value of it


        };
    }

    //Data provider for all query params needed with wrong values
    @DataProvider
    public Object[][] getQueryParamsWithWrongValues() {
        return new Object[][]{

                {CITY, breweriesMap.get(CITY)},// query param CITY with the value of it
                {COUNTREY, breweriesMap.get(COUNTREY)},//query param COUNTREY with the value of it
                {NAME, breweriesMap.get(NAME)},//query param NAME with the value of it
                {STATE, breweriesMap.get(STATE)},//query param STATE with the value of it
                {POSTAL_CODE, breweriesMap.get(POSTAL_CODE)},//query param POSTAL_CODE with the value of it
                {PAGE, breweriesMap.get(PAGE)},//query param PAGE with the value of it
                {PER_PAGE, breweriesMap.get(PER_PAGE)},//query param PER_PAGE with the value of it
                {SORT, breweriesMap.get(SORT)},//query param SORT with the value of it
                {IDS, breweriesMap.get(IDS)},//query param IDS with the value of it
                {DIST, breweriesMap.get(DIST)},
                {TYPE, breweriesMap.get(TYPE)},//query param DIST with the value of it

        };
    }


    //Method useful to get the query param by type

    @DataProvider
    public Object[][] getQueryParamsByType() {
        return new Object[][]{

                {TYPE, MICRO},// type micro
                {TYPE, NANO},//type nano
                {TYPE, REGIONAL},//type nano
                {TYPE, BREWPUB},//type  brewpub
                {TYPE, LARGE},// type large
                {TYPE, PLANNING},// type planning
                {TYPE, BAR},// type bar
                {TYPE, CONTRACT},// type contract
                {TYPE, PROPRIETOR},// type proprietor
                {TYPE, CLOSED},// type closed


        };
    }


    // Method useful for extracting the response body according to the query param entered
    @Test(dataProvider = "getQueryParams")
    public void getBreweriesByQueryParam(String key, Object object) {
        Response res;
        HashMap<String, Object> queryParam = new HashMap<>();
        queryParam.put(key, object);
        System.out.println(object);
        System.out.println(endpoint);
        res = breweries.recuperateBreweriesByQuery(endpoint, queryParam, headersMap);
        System.out.println(res.body().asPrettyString());
        Assertions.assertThat(res.getStatusCode()).isEqualTo(successCode);
        Assertions.assertThat(res.body().asPrettyString()).isNotNull();
        log.info("verifying that the  value of query param entered: is equal to the expected value", res.path(key), object);

    }

    // Method useful for extracting the response by wrong query param
    @Test(dataProvider = "getQueryParamsWithWrongValues")
    public void getBreweriesByWrongQueryParam(String key, Object object) {
        Response res;
        HashMap<String, Object> queryParam = new HashMap<>();
        queryParam.put(key, object);
        res = breweries.recuperateBreweriesByQuery(endpoint, queryParam, headersMap);
        System.out.println(res.body().asPrettyString());
        Assertions.assertThat(res.getStatusCode()).isEqualTo(BadRequestCode);
        Assertions.assertThat(res.body().asPrettyString()).isNotNull();
        log.info("verifying that the query param entered:{}is equal to the expected value{}", res.path(key), object);


    }

}
