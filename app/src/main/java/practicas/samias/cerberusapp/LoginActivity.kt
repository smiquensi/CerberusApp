package practicas.samias.cerberusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

import com.google.android.material.snackbar.Snackbar
import practicas.samias.cerberusapp.data.StoreApplication
import practicas.samias.cerberusapp.data.VsEntity
import practicas.samias.cerberusapp.databinding.ActivityLoginBinding
import java.util.concurrent.LinkedBlockingQueue

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var vs: VsEntity
    private val crewList = getCrew()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var etTIP = binding.etTIP
        var etPass = binding.etPassword


        binding.btnLogin.setOnClickListener {
            if (etTIP.text.toString().isEmpty() || etPass.text.toString().isEmpty()) {
                Snackbar.make(binding.root, "Debe rellenar los datos.", Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.etTIP)
                    .show()
            } else {
                if (checkTip(etTIP) && checkPass(etTIP)){
                    val intent = Intent(this, MenuActivity::class.java)
                    intent.putExtra("data", etTIP.text.toString())
                    startActivity(intent)
                } else {
                    Snackbar.make(binding.root, "Los datos son incorrectos", Snackbar.LENGTH_LONG)
                        .setAnchorView(binding.etTIP)
                        .show()
                    etTIP.text = null
                    etPass.text = null
                }
            }
        }


    }


//    var vs1:VsEntity = VsEntity(0,"Santi",  "Miquel", "273158",
//        "1234", "smiquensi@gmail.com", "635913676",
//        "Iberdrola Burrina","control acesos", true)
//
//    var vs2:VsEntity = VsEntity(0,"Santi",  "Miquel", "admin",
//        "admin", "smiquensi@gmail.com", "635913676",
//        "Iberdrola Burrina","control acesos", true)


    // Comprobamos que el TIP esté en la base de datos
    private fun checkTip(etTip: EditText): Boolean{
        val numTip = crewList.find { it.tip == etTip.text.toString()}?.tip
        return numTip!= null
    }
    // Comprobamos que la contraseña corresponda con el TIP
    private fun checkPass(etTip: EditText): Boolean{
       val numPass = crewList.find { it.tip == etTip.text.toString()}?.password
        return numPass == binding.etPassword.text.toString()
    }

    // Insertar en la bd con un nuevo thread
    private fun addVs(vs: VsEntity){
        Thread{
            StoreApplication.database.vsDAO().insert(vs)
        }.start()
    }

    private fun getCrew(): MutableList<VsEntity>{
        // Configuramos una cola con el tipo de adaptador <MutableList<VsEntity>>
        val queue = LinkedBlockingQueue<MutableList<VsEntity>>()
        Thread{
            val crew = StoreApplication.database.vsDAO().getUsers()
            queue.add(crew)
        }.start()
        //queue.take espera al hilo para devolver el valor qeu devuelve
        return queue.take()
    //println(queue.take().toString())
//        Snackbar.make(binding.root, queue.take().toString(), Snackbar.LENGTH_LONG)
//                    .setAnchorView(binding.etTIP)
//                    .show()
    }

//            room.vsDAO().insert(Vs(1, "Santi", "Miquel", "273158", "1234", "smiquensi@gmail.com", "635913676", "Iberdrola Burrina","control acesos", true))

}


