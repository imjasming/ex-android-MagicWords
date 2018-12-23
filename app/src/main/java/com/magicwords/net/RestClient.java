package com.magicwords.net;

//import com.xiaoming.exercise.mygymclub.net.callback.IError;
//import com.xiaoming.exercise.mygymclub.net.callback.IFailure;
//import com.xiaoming.exercise.mygymclub.net.callback.IRequest;
//import com.xiaoming.exercise.mygymclub.net.callback.ISuccess;
//import com.xiaoming.exercise.mygymclub.net.callback.RequestCallbacks;

import  com.magicwords.net.callback.*;

import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class RestClient {
    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final IRequest REQUEST;
    private final RequestBody BODY;

    RestClient(String url,
               WeakHashMap<String, Object> params,
               ISuccess success,
               IFailure failure,
               IError error,
               IRequest request,
               RequestBody body) {
        this.URL = url;
        this.PARAMS = params;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.REQUEST = request;
        this.BODY = body;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestServiceAPI service = RestCreator.getRestServiceAPI();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            default:
                break;
        }

        if (call != null){
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback(){
        return new RequestCallbacks(
                SUCCESS,
                FAILURE,
                ERROR,
                REQUEST
                );
    }

    public final void get(){
        request(HttpMethod.GET);
    }

    public final void post(){
        request(HttpMethod.POST);
    }
}
