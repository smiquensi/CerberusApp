package practicas.samias.cerberusapp

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import practicas.samias.cerberusapp.databinding.ActivityInformBinding
import java.util.*

class InformActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val timeEditText:TextInputEditText? = binding.informContentScrolling.etInfHour
//        timeEditText?.setOnClickListener { showTimePickerDialog() }

        binding = ActivityInformBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.icBack.setOnClickListener { startActivity(Intent(this, MenuActivity::class.java))
    }
}

//    private fun showTimePickerDialog() {
//        val calendar = Calendar.getInstance()
//        val hour = calendar.get(Calendar.HOUR_OF_DAY)
//        val minute = calendar.get(Calendar.MINUTE)
//
//        val timePickerDialog = TimePickerDialog(this, { _: TimePicker, hourOfDay: Int, minuteOfDay: Int ->
//            val time = String.format("%02d:%02d", hourOfDay, minuteOfDay)
//            val timeEditText: TextInputEditText = findViewById(R.id.tilInf_hour)
//            timeEditText.setText(time)
//        }, hour, minute, true)
//
//        timePickerDialog.show()
//    }
}