package com.example.waterfall.mvitest.domainlayer

import com.example.waterfall.mvitest.datalayer.DataRepository
import rx.Observable
import java.util.*

class MainInteractor {

    private val dataRepository = DataRepository()

    fun loadData() : Observable<LoadViewState> =
            dataRepository.loadData()
                    .map<LoadViewState> { LoadViewState.Result(it) }
                    .startWith(LoadViewState.Progress())
                    .onErrorReturn{ LoadViewState.Error(it.localizedMessage) }

}