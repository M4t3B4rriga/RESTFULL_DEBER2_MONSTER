package ec.edu.monster.service

import ec.edu.monster.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    // Login
    @POST("api/RESTLoginControllerUnitConverter/Login")
    suspend fun login(@Body user: UserModel): Response<Boolean>

    // Conversiones de peso
    @POST("api/RESTUnitConverter/KgToLib")
    suspend fun kgToLb(@Body kg: String): Response<Double>

    @POST("api/RESTUnitConverter/LbToKg")
    suspend fun lbToKg(@Body lb: String): Response<Double>

    // Conversiones de longitud
    @POST("api/RESTUnitConverter/CmToM")
    suspend fun cmToM(@Body cm: String): Response<Double>

    @POST("api/RESTUnitConverter/MToKm")
    suspend fun mToKm(@Body m: String): Response<Double>

    @POST("api/RESTUnitConverter/KmToM")
    suspend fun kmToM(@Body km: String): Response<Double>

    @POST("api/RESTUnitConverter/MmToM")
    suspend fun mmToM(@Body mm: String): Response<Double>

    @POST("api/RESTUnitConverter/MToCm")
    suspend fun mToCm(@Body m: String): Response<Double>
}