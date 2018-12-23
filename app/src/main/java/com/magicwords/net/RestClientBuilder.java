package com.magicwords.net;

import com.magicwords.net.callback.IError;
import com.magicwords.net.callback.IFailure;
import com.magicwords.net.callback.IRequest;
import com.magicwords.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {
    private String mUrl;
    private final WeakHashMap<String, Object> mParams = new WeakHashMap<>();
    private ISuccess mSuccess;
    private IFailure mFailure;
    private IError mError;
    private IRequest mRequest;
    private RequestBody mBody;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        this.mParams.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        this.mParams.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest request) {
        this.mRequest = request;
        return this;
    }

    public final RestClientBuilder success(ISuccess success) {
        this.mSuccess = success;
        return this;
    }

    public final RestClientBuilder failure(IFailure failure) {
        this.mFailure = failure;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        this.mError = error;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, mParams, mSuccess, mFailure, mError, mRequest, mBody);
    }
}
