package com.example.farmaciamovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadSeleccionarProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadseleccionarproducto);

        ImageView imageViewProducto = findViewById(R.id.imageView2);
        imageViewProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAModificarProductoIbu();
            }
        });

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAModificarProductoParace();
            }
        });

        Button buttonVolver = findViewById(R.id.volver); // Botón en actividadseleccionarproducto
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAInicioAdministrador();
            }
        });
    }

    public void irAModificarProductoIbu() {
        Intent intent = new Intent(this, ActividadModificarProductoIbu.class);
        startActivity(intent);
    }

    public void irAModificarProductoParace() {
        Intent intent = new Intent(this, ActividadModificarProductoParace.class);
        startActivity(intent);
    }

    public void irAInicioAdministrador() {
        Intent intent = new Intent(this, ActividadInicioAdministrador.class);
        startActivity(intent);
    }
}
