package ec.edu.monster.modelo;

import ec.edu.monster.servicio.ApiServicio;
import ec.edu.monster.servicio.ConversionResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConversionModelo {
    private ApiServicio apiServicio;

    public ConversionModelo(ApiServicio apiServicio) {
        this.apiServicio = apiServicio;
    }

    public void convertTemperature(double value, String type, final ConversionCallback callback) {
        Call<ConversionResponse> call = apiServicio.convertirTemperatura(
                new ec.edu.monster.servicio.Conversion(value, type));

        call.enqueue(new Callback<ConversionResponse>() {
            @Override
            public void onResponse(Call<ConversionResponse> call, Response<ConversionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getResultado());
                } else {
                    callback.onError("Error en la respuesta del servidor");
                }
            }

            @Override
            public void onFailure(Call<ConversionResponse> call, Throwable t) {
                callback.onError("Error de conexión: " + t.getMessage());
            }
        });
    }

    public interface ConversionCallback {
        void onSuccess(double result);
        void onError(String message);
    }
}
