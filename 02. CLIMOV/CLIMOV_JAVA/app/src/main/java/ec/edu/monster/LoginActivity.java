package ec.edu.monster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ec.edu.monster.controlador.AuthControlador;
import ec.edu.monster.modelo.AuthModelo;
import ec.edu.monster.vista.AuthVista;

public class LoginActivity extends AppCompatActivity implements AuthVista {
    private EditText etUsuario, etPassword;
    private TextView tvError;
    private AuthControlador authControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        tvError = findViewById(R.id.tvError);
        Button btnLogin = findViewById(R.id.btnLogin);

        AuthModelo authModel = new AuthModelo();
        authControlador = new AuthControlador(authModel, this, this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                authControlador.validateCredentials(usuario, password);
            }
        });
    }

    @Override
    public void showError(String message) {
        tvError.setText(message);
        tvError.setVisibility(View.VISIBLE);
    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}