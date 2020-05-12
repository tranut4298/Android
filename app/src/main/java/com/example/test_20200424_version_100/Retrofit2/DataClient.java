package com.example.test_20200424_version_100.Retrofit2;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface DataClient {

    @Multipart
    @POST("upload_image.php")
    Call<String> UploadPhoto(@Part MultipartBody.Part photo);

    @FormUrlEncoded
    @POST("user_signin.php")
    Call<String> InsertData(@Field("username") String username2
            , @Field("password") String password2
            , @Field("image_user") String image_user2);
    @FormUrlEncoded
    @POST("user_login.php")
    Call<List<User>> LoginData(@Field("username") String username1
            , @Field("password") String password1);

    @GET("user_delete.php")
    Call<String> DeleteData(@Query("id") String id3
            , @Query("image_user") String image_user3);
}
