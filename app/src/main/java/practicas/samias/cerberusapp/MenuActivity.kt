package practicas.samias.cerberusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import practicas.samias.cerberusapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvInitServ.setOnClickListener{
            Snackbar.make(binding.root, "Servicio iniciado con exito", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.cvInform)
                .show()
        }
        binding.cvInform.setOnClickListener{
            startActivity(Intent(this, InformActivity::class.java))
        }
        binding.cvRound.setOnClickListener{
            startActivity(Intent(this, RoundActivity::class.java))
        }
        binding.cvDataUser.setOnClickListener{
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
}