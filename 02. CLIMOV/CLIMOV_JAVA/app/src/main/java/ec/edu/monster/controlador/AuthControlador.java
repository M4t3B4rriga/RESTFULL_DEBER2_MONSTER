package ec.edu.monster.controlador;

import android.content.Context;

import ec.edu.monster.modelo.AuthModelo;
import ec.edu.monster.utils.AuthHelper;
import ec.edu.monster.vista.AuthVista;

public class AuthControlador {
    private AuthModelo modelo;
    private AuthVista vista;
    private Context context;

    public AuthControlador (AuthModelo modelo, AuthVista vista, Context context){
        this.modelo = modelo;
        this.vista = vista;
        this.context = context;
    }
    public void validateCredentials(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            vista.showError("Ingrese usuario y contraseña");
            return;
        }

        if (modelo.validateCredentials(username, password)) {
          AuthHelper.setLoggedIn(context, true);
            vista.navigateToMain();
        } else {
            vista.showError("Credenciales incorrectas");
        }
    }
}