package a.suman.mvparchitecture.Repository

import a.suman.mvparchitecture.Contract.contract
import a.suman.mvparchitecture.Repository.Model.DataTable
import a.suman.mvparchitecture.Repository.Network.RetrofitBuilder
import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import a.suman.mvparchitecture.Presenter.PresenterClass
import a.suman.mvparchitecture.Repository.Model.Database
import a.suman.mvparchitecture.Repository.Network.Datatable2Net
import android.os.AsyncTask
import android.util.Log.d

class Repository(presenterClass: PresenterClass): contract.Model {
    var presenterClass=presenterClass
    var retrofitBuilder=RetrofitBuilder()
    lateinit var responseTable:List<DataTable>
    lateinit var responseData:Datatable2Net


    override fun getData(sol: Int, context: Context) {
        var database=Database.getDatabase(context)

        d("a", "getData executed")
        retrofitBuilder.networkMethods.getResult(sol)
            .enqueue(object : Callback<Datatable2Net> {
                override fun onFailure(call: Call<Datatable2Net>, t: Throwable) {
                    d("a", "onFailure executed")
                    AsyncTask.execute{
                        responseTable=database.dao().SelectAll()
                        presenterClass.fetchData(responseTable)}
                }

                override fun onResponse(
                    call: Call<Datatable2Net>,
                    response: Response<Datatable2Net>
                ) {
                    d("a", "onResponse executed")
                    responseData=response.body()!!
                    responseTable=responseData.photos
                    d("a", "onResponse executed")
                    AsyncTask.execute{
                        d("a", "Async executed")
                    database.dao().DeleteAll()
                    database.dao().insertAll(responseTable)
                    responseTable=database.dao().SelectAll()
                    presenterClass.fetchData(responseTable)}
                }
            }
            )
    }

}
