package ec.edu.monster.controller

import ec.edu.monster.model.ConversionResponse
import ec.edu.monster.model.ConversionType
import ec.edu.monster.service.ApiService
import ec.edu.monster.service.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ConversionController {
    private val apiService: ApiService = RetrofitClient.instance

    suspend fun convert(
        value: String,
        type: ConversionType
    ): ConversionResponse {
        return when (type) {
            ConversionType.KG_TO_LB -> performConversion { apiService.kgToLb(value) }
            ConversionType.LB_TO_KG -> performConversion { apiService.lbToKg(value) }
            ConversionType.CM_TO_M -> performConversion { apiService.cmToM(value) }
            ConversionType.M_TO_KM -> performConversion { apiService.mToKm(value) }
            ConversionType.KM_TO_M -> performConversion { apiService.kmToM(value) }
            ConversionType.MM_TO_M -> performConversion { apiService.mmToM(value) }
            ConversionType.M_TO_CM -> performConversion { apiService.mToCm(value) }
        }
    }

    private suspend fun performConversion(
        conversionCall: suspend () -> Response<Double>
    ): ConversionResponse {
        return try {
            val response = withContext(Dispatchers.IO) {
                conversionCall()
            }

            if (response.isSuccessful) {
                ConversionResponse(
                    success = true,
                    result = response.body(),
                    message = "Conversión exitosa"
                )
            } else {
                ConversionResponse(
                    success = false,
                    error = "Error en la conversión: ${response.code()}"
                )
            }
        } catch (e: Exception) {
            ConversionResponse(
                success = false,
                error = "Error de conexión: ${e.message}"
            )
        }
    }
}