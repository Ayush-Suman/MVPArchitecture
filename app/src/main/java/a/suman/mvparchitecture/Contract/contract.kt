package a.suman.mvparchitecture.Contract

import a.suman.mvparchitecture.Repository.Model.DataTable
import android.content.Context
import android.provider.ContactsContract

interface contract{
    interface View{
        fun update(datalist: List<DataTable>)
    }

    interface Presenter{
        fun transferData(sol:Int, context: Context)
        fun fetchData(datalist:List<DataTable>)
    }

    interface Model{
    fun getData(sol:Int, context: Context)
    }
}