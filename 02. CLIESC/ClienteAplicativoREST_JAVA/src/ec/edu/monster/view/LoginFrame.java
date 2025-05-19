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
public class LoginFrame extends JFrame{
    public JTextField usuarioField;
    public JPasswordField passwordField;
    public JButton loginButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImagePanel background = new ImagePanel("/Resources/fondo_login.jpg");
        background.setLayout(new GridBagLayout());
        setContentPane(background);

     
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setOpaque(false);

        JLabel usuarioLbl = new JLabel("Usuario:");
        usuarioLbl.setForeground(Color.WHITE);

        usuarioField = new JTextField(15);
        usuarioField.setBackground(new Color(255, 255, 255, 180));

        JLabel passwordLbl = new JLabel("Contraseña:");
        passwordLbl.setForeground(Color.WHITE);

        passwordField = new JPasswordField(15);
        passwordField.setBackground(new Color(255, 255, 255, 180));

        loginButton = new JButton("Ingresar");

        formPanel.add(usuarioLbl);
        formPanel.add(usuarioField);
        formPanel.add(passwordLbl);
        formPanel.add(passwordField);
        formPanel.add(new JLabel());
        formPanel.add(loginButton);

        background.add(formPanel, new GridBagConstraints());
    }
}
