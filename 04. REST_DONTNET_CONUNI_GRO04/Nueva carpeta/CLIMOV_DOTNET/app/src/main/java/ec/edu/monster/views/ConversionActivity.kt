package ec.edu.monster.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ec.edu.monster.controller.ConversionController
import ec.edu.monster.databinding.ActivityConversionBinding
import ec.edu.monster.model.ConversionType
import kotlinx.coroutines.launch

class ConversionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConversionBinding
    private val conversionController = ConversionController()

    private val conversionTypes = listOf(
        "Kilogramos a Libras" to ConversionType.KG_TO_LB,
        "Libras a Kilogramos" to ConversionType.LB_TO_KG,
        "Centímetros a Metros" to ConversionType.CM_TO_M,
        "Metros a Kilómetros" to ConversionType.M_TO_KM,
        "Kilómetros a Metros" to ConversionType.KM_TO_M,
        "Milímetros a Metros" to ConversionType.MM_TO_M,
        "Metros a Centímetros" to ConversionType.M_TO_CM
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConversionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupConvertButton()
        setupLogoutButton() // Añadir esta línea
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            conversionTypes.map { it.first }
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerConversionType.adapter = adapter
    }

    private fun setupConvertButton() {
        binding.btnConvert.setOnClickListener {
            val value = binding.etValue.text.toString()
            if (value.isNotEmpty()) {
                val selectedPosition = binding.spinnerConversionType.selectedItemPosition
                val conversionType = conversionTypes[selectedPosition].second

                convertValue(value, conversionType)
            } else {
                binding.tvError.text = "Por favor ingrese un valor"
            }
        }
    }

    private fun setupLogoutButton() {
        binding.btnLogout.setOnClickListener {
            // Limpiar cualquier dato de sesión si es necesario
            // Por ejemplo, si usas SharedPreferences:
            // getSharedPreferences("AppPrefs", MODE_PRIVATE).edit().clear().apply()

            // Redirigir al LoginActivity
            val intent = Intent(this, LoginActivity::class.java)

            // Limpiar el stack de actividades para que no pueda volver atrás
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            finish()
        }
    }

    private fun convertValue(value: String, type: ConversionType) {
        binding.progressBar.visibility = View.VISIBLE
        binding.tvError.text = ""
        binding.tvResult.text = ""
        binding.tvResultTitle.visibility = View.GONE

        lifecycleScope.launch {
            val result = conversionController.convert(value, type)

            binding.progressBar.visibility = View.GONE

            if (result.success) {
                binding.tvResultTitle.visibility = View.VISIBLE
                binding.tvResult.text = String.format("%.4f", result.result)
            } else {
                binding.tvError.text = result.error
            }
        }
    }
}