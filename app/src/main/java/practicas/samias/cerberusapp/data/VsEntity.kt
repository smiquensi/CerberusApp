package practicas.samias.cerberusapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "VsEntity")
data class VsEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String = "",
    val surname:String = "",
    val tip: String,
    val password: String,
    val email: String,
    val phone: String = "",
    val workPlace: String = "",
    val workCharge: String = "",
    val supervisor: Boolean = false
        )