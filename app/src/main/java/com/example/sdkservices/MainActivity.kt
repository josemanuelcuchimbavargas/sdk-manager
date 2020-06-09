package com.example.sdkservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sdkservices.Entities.Customer
import com.example.sdkservices.Routers.RouterService
import com.example.sdkservices.Services.ApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RouterService().getAll()?.subscribe({ response -> onResponse(response)}, { });

    }

    private fun onResponse(response: ArrayList<Customer>) {
        Log.d("ON RESPONSE SERVICES", "Tamaño del arreglo hola =>" + response?.size)
    }

}