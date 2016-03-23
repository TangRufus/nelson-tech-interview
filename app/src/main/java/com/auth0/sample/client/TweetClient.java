package com.auth0.sample.client;


import com.loopj.android.http.*;

public class TweetClient  {
    private static final String BASE_URL = "http://localhost:3001/";

    private static AsyncHttpClient client = new AsyncHttpClient();



    public static void addHeader(String header, String value){
        client.addHeader(header,value);
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    public void get(String image, FileAsyncHttpResponseHandler fileAsyncHttpResponseHandler) {
        client.get(image, fileAsyncHttpResponseHandler);

    }
}
