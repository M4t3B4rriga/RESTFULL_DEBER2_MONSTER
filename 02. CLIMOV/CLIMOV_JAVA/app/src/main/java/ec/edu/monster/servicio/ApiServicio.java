package ec.edu.monster.servicio;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServicio {
    @POST("api/conversion")
    Call<ConversionResponse> convertirTemperatura(@Body Conversion conversion);
}
