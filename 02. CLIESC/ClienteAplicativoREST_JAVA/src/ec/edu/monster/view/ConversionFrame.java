/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author sebas
 */
public class ConversionFrame extends JFrame{
    public JTextField valorField;
    public JComboBox<String> tipoCombo;
    public JButton convertirBtn;
    public JLabel resultadoLbl;

    public ConversionFrame() {
        setTitle("Conversión de Temperatura");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImagePanel background = new ImagePanel("/Resources/fondo_conversion.jpg");
        background.setLayout(new GridBagLayout());
        setContentPane(background);

      
        JPanel contentPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        contentPanel.setOpaque(false);

        JLabel valorLbl = new JLabel("Ingrese valor:");
        valorLbl.setForeground(Color.WHITE);

        valorField = new JTextField(10);
        valorField.setBackground(new Color(255, 255, 255, 200));

        tipoCombo = new JComboBox<>(new String[]{"Celsius a Fahrenheit", "Fahrenheit a Celsius"});
        tipoCombo.setBackground(new Color(255, 255, 255, 200));

        convertirBtn = new JButton("Convertir");

        resultadoLbl = new JLabel("Resultado:");
        resultadoLbl.setForeground(Color.WHITE);

        contentPanel.add(valorLbl);
        contentPanel.add(valorField);
        contentPanel.add(tipoCombo);
        contentPanel.add(convertirBtn);
        contentPanel.add(resultadoLbl);

        background.add(contentPanel, new GridBagConstraints());
    }
}
