package com.example.farmaciamovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadProductoIbu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_productoibu);

        Button botonComprar = findViewById(R.id.button2);
        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActividadProductoIbu.this, ActividadCarritoCompra.class);


                int imagenProducto = R.drawable.ibuprofeno;


                String nombreProducto = "Ibuprofeno 600 Mg";
                String cantidad = "10 Unidades";
                String precio = "$ 1000 CLP";


                intent.putExtra("nombre_producto", nombreProducto);
                intent.putExtra("cantidad", cantidad);
                intent.putExtra("precio", precio);
                intent.putExtra("imagen", imagenProducto);


                startActivityForResult(intent, 1);
            }
        });
    }
}
