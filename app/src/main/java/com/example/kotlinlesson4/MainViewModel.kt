package com.example.kotlinlesson4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var counter = MutableLiveData<Int>()
    var commands = MutableLiveData<String>()

    private var mCounter = 0
    private var plus = "+"
    private var minus = "-"

    fun onIncrementClick() {
        mCounter++
        commands.value = plus
        counter.value = mCounter
    }

    fun onItemDecrementClick() {
        mCounter--
        commands.value = minus
        counter.value = mCounter
    }

}

