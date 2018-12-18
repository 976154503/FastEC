package com.example.latte.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/*
 * 网络请求方法
 * */
public interface RestService {
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> parms);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> parms);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String, Object> parms);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> parms);

    //添加 Streaming 注释 防止内存溢出
    @Streaming
    @GET
    Call<ResponseBody> downlode(@Url String url, @QueryMap Map<String, Object> parms);

    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}
