package com.example.sdkservices

import android.util.Log
import com.example.sdkservices.Entities.Customer
import com.example.sdkservices.Services.ApiAdapter
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : Callback<ArrayList<Customer>> {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        val call = ApiAdapter.getApiService().data;
        call.enqueue(this)
    }

    override fun onFailure(call: Call<ArrayList<Customer>>, t: Throwable) {
        System.out.print("Esta fallando karnal")
    }

    override fun onResponse(
        call: Call<ArrayList<Customer>>,
        response: Response<ArrayList<Customer>>
    ) {
        if(response.isSuccessful()){
            val customers: ArrayList<Customer>? = response.body();
            if (customers != null) {
                System.out.print("Tamaño del arreglo =>" + customers.size)
            };
        }
    }
}