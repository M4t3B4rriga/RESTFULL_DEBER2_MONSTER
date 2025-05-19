package ec.edu.monster.controller

import ec.edu.monster.model.ConversionResponse
import ec.edu.monster.model.UserModel
import ec.edu.monster.service.ApiService
import ec.edu.monster.service.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginController {
    private val apiService: ApiService = RetrofitClient.instance

    suspend fun login(user: UserModel): ConversionResponse {
        return try {
            val response = withContext(Dispatchers.IO) {
                apiService.login(user)
            }

            if (response.isSuccessful && response.body() == true) {
                ConversionResponse(success = true)
            } else {
                ConversionResponse(success = false, error = "Credenciales incorrectas")
            }
        } catch (e: Exception) {
            ConversionResponse(success = false, error = "Error de conexión: ${e.message}")
        }
    }
}