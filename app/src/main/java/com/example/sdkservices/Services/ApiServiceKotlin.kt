package com.example.sdkservices.Services;

import com.example.sdkservices.Entities.Customer;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

interface ApiService {

    @GET("todos")
    fun getData(): Observable<ArrayList<Customer>>;

}
