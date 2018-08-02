package id.co.pln.ipro.api;

import id.co.pln.ipro.model.InsertClass;
import id.co.pln.ipro.model.UjiClass;
import id.co.pln.ipro.model.LoginClass;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IproClient {
    @POST("Login/LoginApi")
    @FormUrlEncoded
    Call<LoginClass> LoginUser(@Field("data") String data);

    @GET("UjiProteksi/GetUji")
    Call<UjiClass> getDataUjiProteksi(
            @Query("penyulang") String penyulang,
            @Query("rele") String rele
    );

    @GET("OutputUji/GetOutputUji")
    Call<UjiClass> getOutputUji();

    @POST("UjiProteksi/SaveUji")
    @FormUrlEncoded
    Call<InsertClass> insertDataUji(@Field("jsondata") String jsondata);
}
