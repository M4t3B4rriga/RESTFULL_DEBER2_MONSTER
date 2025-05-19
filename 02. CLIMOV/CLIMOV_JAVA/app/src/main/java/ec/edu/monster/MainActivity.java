package ec.edu.monster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ec.edu.monster.controlador.ConversionControlador;
import ec.edu.monster.modelo.ConversionModelo;
import ec.edu.monster.servicio.ApiServicio;
import ec.edu.monster.servicio.RetrofitClient;
import ec.edu.monster.utils.AuthHelper;
import ec.edu.monster.vista.ConversionVista;

public class MainActivity extends AppCompatActivity implements ConversionVista {
    private EditText etValor;
    private RadioGroup rgTipoConversion;
    private TextView tvResultado;
    private ConversionControlador conversionControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!AuthHelper.isLoggedIn(this)) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        etValor = findViewById(R.id.etValor);
        rgTipoConversion = findViewById(R.id.rgTipoConversion);
        tvResultado = findViewById(R.id.tvResultado);
        Button btnConvertir = findViewById(R.id.btnConvertir);
        Button btnLogout = findViewById(R.id.btnLogout);

        ApiServicio apiServicio = RetrofitClient.getApiService();
        ConversionModelo conversionModelo = new ConversionModelo(apiServicio);
        conversionControlador = new ConversionControlador(conversionModelo, this);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorStr = etValor.getText().toString();
                if (valorStr.isEmpty()) {
                    showError("Ingrese un valor");
                    return;
                }

                double valor = Double.parseDouble(valorStr);
                String tipoConversion = rgTipoConversion.getCheckedRadioButtonId() == R.id.rbCelsiusFahrenheit
                        ? "celsiusToFahrenheit" : "fahrenheitToCelsius";

                conversionControlador.convert(valor, tipoConversion);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthHelper.setLoggedIn(MainActivity.this, false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    @Override
    public void showResult(double result) {
        tvResultado.setText("Resultado: " + result);
    }

    @Override
    public void showError(String message) {
        tvResultado.setText("Error: " + message);
    }
}