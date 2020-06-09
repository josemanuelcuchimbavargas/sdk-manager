package com.example.sdkservicelibrary.Services

import com.example.sdkservicelibrary.Entities.Customer

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

interface ApiService {

    @GET("todos")
    fun getData(): Observable<ArrayList<Customer>>;

}
