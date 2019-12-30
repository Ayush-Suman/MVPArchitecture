package a.suman.mvparchitecture.Repository.Model

import android.provider.ContactsContract
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="ImageData")
data class DataTable(
@PrimaryKey
var img_src:String="",
var earth_date:String?=null
)