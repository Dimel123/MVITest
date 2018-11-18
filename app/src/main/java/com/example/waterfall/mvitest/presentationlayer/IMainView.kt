package com.example.waterfall.mvitest.presentationlayer

import com.example.waterfall.mvitest.domainlayer.LoadViewState
import rx.Observable
import java.util.*

interface IMainView {

    fun uploadIntent(): Observable<Void>

    fun render(loadViewState: LoadViewState)

}