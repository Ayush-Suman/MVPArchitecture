package a.suman.mvparchitecture.Presenter

import a.suman.mvparchitecture.Contract.contract
import a.suman.mvparchitecture.Repository.Model.DataTable
import a.suman.mvparchitecture.Repository.Repository
import android.content.Context

class PresenterClass(view:contract.View): contract.Presenter {
    var repository:Repository= Repository(this@PresenterClass)
    var view=view

    override fun fetchData(datalist:List<DataTable>, state:String){
        view.update(datalist, state)
    }
    override fun transferData(sol:Int, context: Context) {
        repository.getData(sol, context)
    }

}