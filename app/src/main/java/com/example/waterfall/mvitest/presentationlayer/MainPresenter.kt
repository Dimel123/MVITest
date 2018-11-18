package com.example.waterfall.mvitest.presentationlayer

import android.util.Log
import com.example.waterfall.mvitest.domainlayer.MainInteractor
import rx.android.schedulers.AndroidSchedulers

class MainPresenter {

    private var mainView: IMainView? = null
    private var mainInteractor = MainInteractor()

    fun onCreateView(mainView: IMainView) {
        this.mainView = mainView
        mainView.uploadIntent()
                .flatMap { mainInteractor.loadData() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mainView.render(it)
                }, {
                    Log.d("test", "error: $it")
                })


    }

}