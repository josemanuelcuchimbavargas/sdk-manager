package com.example.sdkservicelibrary

import com.example.sdkservicelibrary.Entities.Customer
import com.example.sdkservicelibrary.Services.ApiAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Routers{

    fun getAll(): Observable<ArrayList<Customer>>?  {

        val apiAdapter: ApiAdapter = ApiAdapter();

        val compositeDisposable = CompositeDisposable()
        return compositeDisposable?.add(
            apiAdapter.getApiService()?.getData()
                ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io()));
    }
}

private fun Any.add(subscribeOn: Observable<ArrayList<Customer>>?): Observable<ArrayList<Customer>>? {
    return subscribeOn;
}