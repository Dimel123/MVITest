package com.example.waterfall.mvitest.presentationlayer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.waterfall.mvitest.R
import com.example.waterfall.mvitest.domainlayer.LoadViewState
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable

class MainActivity : AppCompatActivity(), IMainView {

    var mainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.onCreateView(this)
    }

    override fun uploadIntent(): Observable<Void> =
            RxView.clicks(btnUpload)

    override fun render(loadViewState: LoadViewState) {
        when (loadViewState) {
            is LoadViewState.Progress -> showProgress()
            is LoadViewState.Error -> showError(loadViewState.error)
            is LoadViewState.Result -> showData(loadViewState.data)
        }
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
        data.visibility = View.GONE
    }

    private fun showError(error: String) {
        progressBar.visibility = View.GONE
        data.visibility = View.VISIBLE
        data.text = error
    }

    private fun showData(dataText: String) {
        progressBar.visibility = View.GONE
        data.visibility = View.VISIBLE
        data.text = dataText
    }
}
