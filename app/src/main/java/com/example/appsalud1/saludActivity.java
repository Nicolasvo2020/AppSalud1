package com.example.appsalud1;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class saludActivity extends AppCompatActivity {
    EditText etNombre, etAltura, etPeso;
    TextView txtResultado, txtResultado1;
    RadioButton rbHombre, rbMujer;
    Button btnCalcular, btnLimpiar;

    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);

        etNombre = findViewById(R.id.etNombre);
        etAltura = findViewById(R.id.etAltura);
        etAltura.setEnabled(false);
        etPeso = findViewById(R.id.etPeso);
        etPeso.setEnabled(false);
        txtResultado = findViewById(R.id.txtResultado);
        txtResultado1 = findViewById(R.id.txtResultado1);
        rbHombre = findViewById(R.id.rbHombre);
        rbMujer = findViewById(R.id.rbMujer);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setEnabled(false);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        rg = findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rbHombre){
                    Toast.makeText(getApplicationContext(),"Elegiste hombre",Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==R.id.rbMujer){
                    Toast.makeText(getApplicationContext(),"Elegiste Mujer",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"No elegiste ninguna opción",Toast.LENGTH_SHORT).show();
                }
                btnCalcular.setEnabled(true);
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double calcular, talla, peso;
                String mensaje = null;
                talla = Double.parseDouble(etAltura.getText().toString());
                peso = Double.parseDouble(etPeso.getText().toString());
                calcular = peso / Math.pow(talla, 2);

                if (calcular < 16.00 )
                    mensaje = String.valueOf("Peso Muy Grave");
                else if (calcular < 18.99)
                    mensaje = String.valueOf("Peso Grave");
                else if (calcular < 20.49)
                    mensaje = String.valueOf("Bajo Peso");
                else if (calcular < 26.99)
                    mensaje = String.valueOf("Peso Normal");
                else if (calcular < 31.99)
                    mensaje = String.valueOf("Sobre Peso");
                else if (calcular < 36.99)
                    mensaje = String.valueOf("Obesidad Grado 1");
                else if (calcular < 41.99)
                    mensaje = String.valueOf("Obesidad Grado II");
                else if (calcular > 42.00)
                    mensaje = String.valueOf("Obesidad Grado III");

                txtResultado.setText(etNombre.getText() + " Su IMC con respecto a su peso " + etPeso.getText() + " es de " + String.format("%.2f", calcular));
                txtResultado1.setText("Categoria de IMC " + mensaje.toString());
            }

        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            etNombre.setText("");
            etAltura.setText("");
            etPeso.setText("");
            txtResultado.setText("");
            txtResultado1.setText("");
            rbHombre.setChecked(false);
            rbMujer.setChecked(false);
            btnCalcular.setEnabled(false);

            }
        });

    }
}