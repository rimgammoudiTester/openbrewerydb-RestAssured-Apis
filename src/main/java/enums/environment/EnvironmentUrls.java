package enums.environment;

public enum EnvironmentUrls {

    /**
     * @Author Rim Gammoudi
     */

    DEV("https://api.openbrewerydb.org"),
    STAGING("http://staging-api.local:3002/v1/breweries"),
    PROD("http://prod-api.local:3003/v1/breweries");

    private final String urlToGet;

    EnvironmentUrls(String url) {
        urlToGet=url;
    }

    public  String getUrl()
    {
        return urlToGet;
    }
}
