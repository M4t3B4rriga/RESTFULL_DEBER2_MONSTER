/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.monster.controller;
import com.edu.monster.model.ConversorService;
import com.edu.monster.view.ConversorVista;
import com.edu.monster.view.LoginVista;

/**
 *
 * @author sebas
 */
public class ConversorControlador {
        private final ConversorVista vista = new ConversorVista();
    private final LoginVista loginVista = new LoginVista();
    private final ConversorService servicio = new ConversorService();

    public void iniciar() {
        if (!loginVista.login()) {
            System.out.println("Credenciales incorrectas. Fin del programa.");
            return;
        }

        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    double c = vista.pedirValor("Celsius");
                    String res1 = servicio.convertir("celsiusToFahrenheit", c);
                    vista.mostrarResultado(res1);
                    break;
                case 2:
                    double f = vista.pedirValor("Fahrenheit");
                    String res2 = servicio.convertir("fahrenheitToCelsius", f);
                    vista.mostrarResultado(res2);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
}
