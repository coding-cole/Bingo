package com.coding_cole.bingo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coding_cole.bingo.model.DogBreed

class ListViewModel : ViewModel() {
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 = DogBreed(
            "!",
            "Corgi",
            "15yrs",
            "BreedGroup",
            "BredFor",
            "Temperaments",
            ""
        )
        val dog2 = DogBreed(
            "2",
            "German Shepherd",
            "23yrs",
            "BreedGroup",
            "BredFor",
            "Temperaments",
            ""
        )
        val dog3 = DogBreed(
            "3",
            "Alsatian",
            "20yrs",
            "BreedGroup",
            "BredFor",
            "Temperaments",
            ""
        )

        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3)
        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false


    }
}