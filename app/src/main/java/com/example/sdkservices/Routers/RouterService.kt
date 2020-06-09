package com.example.sdkservices.Routers

import com.example.sdkservices.Entities.Customer
import com.example.sdkservices.Services.ApiAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RouterService {

    fun getAll(): Observable<ArrayList<Customer>>?  {

        val compositeDisposable = CompositeDisposable()
       return compositeDisposable?.add(ApiAdapter.getApiService().getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()));

    }

}

private fun Any.add(subscribeOn: Observable<ArrayList<Customer>>?): Observable<ArrayList<Customer>>? {
    return subscribeOn;
}

