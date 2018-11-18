package com.example.waterfall.mvitest.domainlayer

interface LoadViewState {

    class Progress: LoadViewState

    class Result(val data: String): LoadViewState

    class Error(var error: String): LoadViewState

}