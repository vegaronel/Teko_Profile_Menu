package com.learn.learnviewmodel.presentation.viewmodel

import androidx.lifecycle.ViewModel

class DummyData : ViewModel() {
    private val dogs = listOf<String>(
        "Ekko",
        "Nero",
        "Garry",
        "Semi"
    )

    fun getDogs() : List<String> {
        return dogs
    }
}
