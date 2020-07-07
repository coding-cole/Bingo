package com.coding_cole.bingo.model

import io.reactivex.Single
import retrofit2.http.GET

interface DogsAPI {
    @GET("DevTides/DogsApi/master/dogs.json")
    fun getDogs(): Single<List<DogBreed>>
}