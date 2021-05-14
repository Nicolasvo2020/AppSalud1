package com.example.appsalud1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btncalculado, btnsalud, btnejercicios, btndieta;
    Button btnsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncalculado=(ImageButton)findViewById(R.id.btncalculadora);
        btnsalud=(ImageButton)findViewById(R.id.btnsalud);
        btnejercicios=(ImageButton)findViewById(R.id.btnejercicios);
        btndieta=(ImageButton)findViewById(R.id.btndieta);
        btnsalir=(Button)findViewById(R.id.btnsalir);

        btndieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formdieta = new Intent(MainActivity.this,dietaActivity.class);
                startActivity(formdieta);
            }
        });

        btncalculado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formcalculadora = new Intent(MainActivity.this,calculadoraActivity.class);
                startActivity(formcalculadora);
            }
        });

        btndieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formdieta = new Intent(MainActivity.this,dietaActivity.class);
                startActivity(formdieta);
            }
        });

        btnsalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formsalud = new Intent(MainActivity.this,saludActivity.class);
                startActivity(formsalud);
            }
        });

        btnejercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formejercicios = new Intent(MainActivity.this,ejerciciosActivity.class);
                startActivity(formejercicios);
            }
        });

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnejercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagina= new Intent(Intent.ACTION_VIEW, Uri.parse("https://unimeal.com/es/step-goal"));
                startActivity(pagina);
            }
        });

    }
}