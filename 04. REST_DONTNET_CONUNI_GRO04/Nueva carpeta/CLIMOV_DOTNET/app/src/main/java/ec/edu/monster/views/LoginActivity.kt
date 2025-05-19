package ec.edu.monster.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ec.edu.monster.controller.LoginController
import ec.edu.monster.model.UserModel
import kotlinx.coroutines.launch
import ec.edu.monster.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginController = LoginController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Valores por defecto para pruebas
        binding.etUsername.setText("MONSTER")
        binding.etPassword.setText("MONSTER9")

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                login(UserModel(username, password))
            } else {
                binding.tvError.text = "Por favor complete todos los campos"
            }
        }
    }

    private fun login(user: UserModel) {
        binding.progressBar.visibility = View.VISIBLE
        binding.tvError.text = ""

        lifecycleScope.launch {
            val result = loginController.login(user)

            binding.progressBar.visibility = View.GONE

            if (result.success) {
                Toast.makeText(
                    this@LoginActivity,
                    "Login exitoso",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(this@LoginActivity, ConversionActivity::class.java)
                )
                finish()
            } else {
                binding.tvError.text = result.error
            }
        }
    }
}