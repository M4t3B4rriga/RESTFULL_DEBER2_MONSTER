/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controller;
import ec.edu.monster.model.ConversionService;
import ec.edu.monster.view.ConversionFrame;
import ec.edu.monster.view.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author sebas
 */
public class AppController {
    private final LoginFrame loginFrame;
    private final ConversionFrame conversionFrame;
    private final ConversionService service;

    public AppController() {
        loginFrame = new LoginFrame();
        conversionFrame = new ConversionFrame();
        service = new ConversionService();
        initLogin();
        initConversion();
    }

    public void iniciar() {
        loginFrame.setVisible(true);
    }

    private void initLogin() {
        loginFrame.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = loginFrame.usuarioField.getText();
                String pass = new String(loginFrame.passwordField.getPassword());

                if ("MONSTER".equals(user) && "MONSTER9".equals(pass)) {
                    loginFrame.dispose();
                    conversionFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Credenciales incorrectas");
                }
            }
        });
    }

    private void initConversion() {
        conversionFrame.convertirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(conversionFrame.valorField.getText());
                    String tipoSeleccionado = (String) conversionFrame.tipoCombo.getSelectedItem();
                    String tipo = tipoSeleccionado.contains("Celsius") ? "celsiusToFahrenheit" : "fahrenheitToCelsius";
                    String respuesta = service.convertir(tipo, valor);
                    conversionFrame.resultadoLbl.setText("Resultado: " + respuesta);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(conversionFrame, "Ingrese un número válido");
                }
            }
        });
    }
}
