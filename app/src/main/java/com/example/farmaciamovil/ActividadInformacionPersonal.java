package com.example.farmaciamovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;

public class ActividadInformacionPersonal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadinformacionpersonal);

        final EditText editTextNombreCompleto = findViewById(R.id.editTextNombreCompleto);
        final EditText editTextCorreoElectronico = findViewById(R.id.editTextCorreoElectronico);
        final EditText editTextNumeroTelefono = findViewById(R.id.editTextNumeroTelefono);
        final EditText editTextGenero = findViewById(R.id.editTextGenero);

        Button buttonVolver = findViewById(R.id.button);

        ImageView imageView = findViewById(R.id.imageView3);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });



        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadInformacionPersonal.this, ActividadInicio.class);
                startActivity(intent);
            }
        });
    }
}