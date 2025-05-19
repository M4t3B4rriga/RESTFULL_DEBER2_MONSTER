package ec.edu.monster.controlador;


import ec.edu.monster.modelo.ConversionModelo;
import ec.edu.monster.vista.ConversionVista;

public class ConversionControlador {
    private ConversionModelo modelo;
    private ConversionVista vista;

    public ConversionControlador(ConversionModelo modelo, ConversionVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void convert(double value, String type) {
        if (value == 0) {
            vista.showError("Ingrese un valor válido");
            return;
        }

        modelo.convertTemperature(value, type, new ConversionModelo.ConversionCallback() {
            @Override
            public void onSuccess(double result) {
                vista.showResult(result);
            }

            @Override
            public void onError(String message) {
                vista.showError(message);
            }
        });
    }

}

