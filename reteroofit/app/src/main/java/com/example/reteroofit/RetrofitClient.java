package com.example.reteroofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


  public static Retrofit retrofit;
  public  static  String BASE_URL ="https://reqres.in/";

 public static Retrofit getRetrofitInsatance (){

      if(retrofit==null)
      {
          retrofit = new Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
      }

      return  retrofit;
  }

}
