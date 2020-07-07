package com.coding_cole.bingo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coding_cole.bingo.model.DogBreed

class DetailViewModel: ViewModel() {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch() {
        val dog = DogBreed(
            "10",
            "Greyhound",
            "6-10yrs",
            "BreedGroup",
            "BredFor",
            "Temperaments",
            ""
        )
        dogLiveData.value = dog

    }
}