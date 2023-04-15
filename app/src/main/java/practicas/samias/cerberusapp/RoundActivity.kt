package practicas.samias.cerberusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import practicas.samias.cerberusapp.databinding.ActivityInformBinding
import practicas.samias.cerberusapp.databinding.ActivityRoundBinding

class RoundActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round)

        binding = ActivityRoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))}
    }
}