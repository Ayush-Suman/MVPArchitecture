package a.suman.mvparchitecture.Repository.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    val retrofit= Retrofit.Builder().
        baseUrl(
            "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/").
        addConverterFactory(GsonConverterFactory.create()).
        build()
        val networkMethods=retrofit.create(NetworkMethods::class.java)
}