package com.carles.carleskotlin.poi.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PoiService {

    @GET("points")
    fun getPoiList(): Single<PoiListResponseDto>

    @GET("points/{id}")
    fun getPoiDetail(@Path("id") id: String): Single<PoiResponseDto>

}