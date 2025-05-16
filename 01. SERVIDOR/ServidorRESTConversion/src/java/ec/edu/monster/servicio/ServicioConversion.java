/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicio;
/**
 *
 * @author sebas
 */
public class ServicioConversion {
    public double convertir(double valor, String tipo) {
        if ("celsiusToFahrenheit".equals(tipo)) {
            return (valor * 9/5) + 32;
        } else if ("fahrenheitToCelsius".equals(tipo)) {
            return (valor - 32) * 5/9;
        } else {
            throw new IllegalArgumentException("Tipo de conversión inválido");
        }
    }
}
