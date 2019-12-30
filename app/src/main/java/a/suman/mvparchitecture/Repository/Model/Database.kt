package a.suman.mvparchitecture.Repository.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataTable::class], version=1)
abstract class Database: RoomDatabase() {
    abstract fun dao(): DAO

    companion object {
        @Volatile
        private var instance:a.suman.mvparchitecture.Repository.Model.Database?=null
        fun getDatabase(context: Context):a.suman.mvparchitecture.Repository.Model.Database{
            val instance= Room.databaseBuilder(
                context.applicationContext,
                a.suman.mvparchitecture.Repository.Model.Database::class.java,
                "NASA").build()
            Companion.instance = instance
            return instance
        }
    }

}