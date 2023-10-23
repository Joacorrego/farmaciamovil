package com.example.farmaciamovil;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadAnadirDireccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadanadirdirrecion);

        Button buttonAddAddress = findViewById(R.id.buttonAddAddress);
        buttonAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    public void volverAActividadMisDirecciones(View view) {
        Intent intent = new Intent(this, ActividadMisDirecciones.class);
        startActivity(intent);
    }
}
