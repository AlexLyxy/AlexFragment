package com.alexlyxy.alexfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val messageForActivity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForAlexFrag: MutableLiveData<String> by lazy {
        MutableLiveData<String>()}

    val messageForAlexTwoFrag: MutableLiveData<String> by lazy {
        MutableLiveData<String>()}
}