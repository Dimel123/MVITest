package com.example.waterfall.mvitest.datalayer

import rx.Observable
import rx.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class DataRepository {

    fun loadData(): Observable<String> =
            Observable.just("Hello world")
                    .delay(2000, TimeUnit.MILLISECONDS)
                    .map {
                        if (randomError()) {
                            throw RuntimeException("Data Error")
                        } else {
                            it
                        }
                    }
                    .subscribeOn(Schedulers.computation())

    private fun randomError() = Random().nextBoolean()


}