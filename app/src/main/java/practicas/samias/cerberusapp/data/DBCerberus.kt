package practicas.samias.cerberusapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [VsEntity::class],
    version = 1
)
abstract class DBCerberus: RoomDatabase(){
    abstract fun vsDAO():VsDAO
}