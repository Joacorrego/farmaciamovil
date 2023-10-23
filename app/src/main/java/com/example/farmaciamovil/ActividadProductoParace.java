package com.example.farmaciamovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadProductoParace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_productoparace);


        Button buttonComprarParace = findViewById(R.id.buttonComprarParace);


        buttonComprarParace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreProducto = "Paracetamol";
                String cantidad = "20 Unidades";
                String precio = "$ 600 CLP";
                int imagenProducto = R.drawable.paracetamol;


                Intent intent = new Intent(ActividadProductoParace.this, ActividadCarritoCompra.class);
                intent.putExtra("nombre_producto", nombreProducto);
                intent.putExtra("cantidad", cantidad);
                intent.putExtra("precio", precio);
                intent.putExtra("imagen", imagenProducto);


                startActivity(intent);
            }
        });
    }
}
