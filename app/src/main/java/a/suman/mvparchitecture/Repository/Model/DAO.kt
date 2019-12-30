package a.suman.mvparchitecture.Repository.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO{
    @Query("SELECT * FROM imagedata")
    fun SelectAll(): List<DataTable>

    @Query("DELETE FROM imagedata")
    fun DeleteAll()

    @Insert
    fun insertAll(table:List<DataTable>)
}