package com.cricket.test.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cricket.test.model.CricketResp
import com.cricket.test.repository.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(private val repo: MatchRepository):ViewModel() {




    private val mCricketRespDataStr = MutableLiveData<ResponseBody>()
    val mCricketDataStr: LiveData<ResponseBody> get() = mCricketRespDataStr

    /*private val mCricketRespData = MutableLiveData<CricketResp>()
    val mCricketData: LiveData<CricketResp> get() = mCricketRespData*/

    init {
        getMatchStr()
    }
/*
    fun getMatch() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getMatchDetails().let { response ->
                if (response.isSuccessful) {
                    mCricketRespData.postValue(response.body())
                } else {
                    println("Error ${response.errorBody()}")
                }
            }

        }

    }*/

    fun getMatchStr() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getMatchDetailBody().let { response ->
                if (response.isSuccessful) {
                    mCricketRespDataStr.postValue(response.body())
                } else {
                    println("Error ${response.errorBody()}")
                }
            }

        }

    }



}