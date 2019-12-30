package a.suman.mvparchitecture.Repository.Network

import a.suman.mvparchitecture.Repository.Model.DataTable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkMethods{
    @GET("photos")
    fun getResult(@Query("sol") sol: Int, @Query("api_key") api_key: String = "9CEiCDSukUbfXe9UCloBSrekqvvnipq9ezhrE4Ny"): Call<Datatable2Net>
}