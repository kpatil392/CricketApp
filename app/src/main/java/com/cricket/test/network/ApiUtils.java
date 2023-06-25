package com.cricket.test.network;

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "mzbmx";
    public static ApiService getAPIServices() {
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }

}