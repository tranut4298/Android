package com.example.test_20200424_version_100.Retrofit2;

public class APIUtils {
    public static final String Base_Url = "http://192.168.1.4/Student/Bien_Bao_20200424/";

    //--Nhan va gui du lieu di chua trong interface
    public static DataClient getData(){
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
