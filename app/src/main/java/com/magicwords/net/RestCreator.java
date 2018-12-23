package com.magicwords.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Create Retrofit
 */
public class RestCreator {
    /**
     * 该段代码的 PARAMS 为全局静态变量，线程不安全，望引以为戒
     */
    /*private static class ParamsHolder{
        private static final WeakHashMap<String,Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String,Object> getParams(){
        return ParamsHolder.PARAMS;
    }*/

    public static RestServiceAPI getRestServiceAPI(){
        return RestServiceAPIHolder.REST_SERVICE_API;
    }

    private static final class RetrofitHolder{
        private static final String BASE_URL = "http://192.168.10.105:8080";
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                /*.addConverterFactory(GsonConverterFactory.create())*/
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OKHttpHolder{
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceAPIHolder {
        private static final RestServiceAPI REST_SERVICE_API = RetrofitHolder.RETROFIT_CLIENT.create(RestServiceAPI.class);
    }
}
