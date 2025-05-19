package ec.edu.monster.model

data class ConversionResponse(
    val success: Boolean,
    val result: Double? = null,
    val error: String? = null,
    val message: String? = null
)