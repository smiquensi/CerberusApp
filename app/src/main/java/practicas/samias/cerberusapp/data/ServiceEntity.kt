package practicas.samias.cerberusapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ServiceEntity")
data class ServiceEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val hour: String ="",
    val subject:String = "",
    //@ForeignKey
    val idVs:Int)