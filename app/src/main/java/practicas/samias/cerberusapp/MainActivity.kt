    package practicas.samias.cerberusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.window.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Creamos una constante  de tipo SplashScreen para que instale el splash
        val screenSplash = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inicializamos screenSplash. True -> se queda fijo mientras dure la logica
        // False -> desaparece
        screenSplash.setKeepOnScreenCondition{true}
        // Creamos una constante intent para cargar la siguiente activity
        val intent = Intent(this, LoginActivity::class.java)
        // iniciamos el intent
        startActivity(intent)
        // matamos el splash para que el user no pueda volver a el
        finish()
    }
}