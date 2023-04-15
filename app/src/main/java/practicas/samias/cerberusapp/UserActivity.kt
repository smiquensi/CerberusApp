package practicas.samias.cerberusapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import practicas.samias.cerberusapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getStringExtra("data")
        //val tv:TextView = data.
        //binding.userContentScrolling.etTipVs.text = data

        println("mamonaso -> $data")

        binding.icBack.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
        binding.userContentScrolling.icAddUser!!.setOnClickListener {
                binding.userContentScrolling.cvNewUser!!.visibility = View.VISIBLE
                binding.userContentScrolling.icAddUser!!.visibility = View.GONE
        }

        binding.userContentScrolling.icCloseAddUser!!.setOnClickListener{
            binding.userContentScrolling.cvNewUser!!.visibility = View.GONE
            binding.userContentScrolling.icAddUser!!.visibility = View.VISIBLE
        }

    }


}