package ec.edu.monster.servicio;

import com.google.gson.annotations.SerializedName;

public class ConversionResponse {
    @SerializedName("resultado")
    private double resultado;

    @SerializedName("error")
    private String error;

    public double getResultado() {
        return resultado;
    }

    public String getError() {
        return error;
    }
}
