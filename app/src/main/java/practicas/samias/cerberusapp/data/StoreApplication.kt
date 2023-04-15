package practicas.samias.cerberusapp.data

import android.app.Application
import androidx.room.Room

// Esta clase es para implementar un patron singleton , para que todas las clases puedan acceder a
// la base de datos.
class StoreApplication : Application() {
    // Palabra reservada object nos va a configurar el patron singlenton
    // companion, va a hacer accesible esto al resto de nuestra app
    // Seria equivalente a static
    companion object{
        lateinit var database: DBCerberus
    }

    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(this, DBCerberus::class.java,
            "DBCerberus").build()
    }
}