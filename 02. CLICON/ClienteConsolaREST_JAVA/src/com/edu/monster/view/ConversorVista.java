/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.monster.view;

import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class ConversorVista {
    Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ CONVERSIÓN ---");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        System.out.println("3. Salir");
        System.out.print("Opción: ");
        return sc.nextInt();
    }

    public double pedirValor(String unidad) {
        System.out.print("Ingrese valor en " + unidad + ": ");
        return sc.nextDouble();
    }

    public void mostrarResultado(String resultado) {
        System.out.println("Resultado: " + resultado);
    }
}
