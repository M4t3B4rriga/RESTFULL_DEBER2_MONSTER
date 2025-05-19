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
public class LoginVista {
     public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("LOGIN DEL SISTEMA:");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        return user.equals("monster") && pass.equals("monster9");
    }
}
