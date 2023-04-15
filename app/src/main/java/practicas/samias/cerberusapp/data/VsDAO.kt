package practicas.samias.cerberusapp.data

import androidx.room.*

@Dao
interface VsDAO {

    @Query("SELECT * FROM VsEntity")
    fun getUsers(): MutableList<VsEntity>

    @Query("SELECT * FROM VsEntity WHERE tip=:tip")
    fun getByTip(tip: String): VsEntity

    @Insert
    fun insert(vsEntity: VsEntity)

    @Update
    fun update(vsEntity: VsEntity)

    @Delete
    fun delete(vsEntity: VsEntity)
}