package com.coding_cole.bingo.model

import com.google.gson.annotations.SerializedName

data class DogBreed(
//    note that if the name in the json file matches a val here then no need to serializable, it matches auto
    @SerializedName("id")
    val breedId: String?,

    @SerializedName("name")
    val dogBreed: String?,

    @SerializedName("life_span")
    val lifeSpan: String?,

    @SerializedName("breed_group")
    val breedGroup: String?,

    @SerializedName("bred_for")
    val bredFor: String?,

    @SerializedName("temperaments")
    val temperaments: String?,

    @SerializedName("url")
    val imageUrl: String?
)