package com.example.farmaciamovil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadMisDirecciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadmisdirecciones);


        Button botonAgregarDireccion = findViewById(R.id.agregardirrecion);
        botonAgregarDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActividadMisDirecciones.this, ActividadAnadirDireccion.class);
                startActivity(intent);
            }
        });


        Button botonVolver = findViewById(R.id.volver);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActividadMisDirecciones.this, ActividadInicio.class);
                startActivity(intent);
            }
        });
    }
}
