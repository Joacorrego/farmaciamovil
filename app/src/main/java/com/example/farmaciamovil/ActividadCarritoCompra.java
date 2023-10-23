package com.example.farmaciamovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadCarritoCompra extends AppCompatActivity {

    private TextView textViewNombreProducto;
    private TextView textViewCantidad;
    private TextView textViewPrecio;
    private ImageView imageViewProducto;
    private Spinner spinnerOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadcarritocompra);

        textViewNombreProducto = findViewById(R.id.textoNombreProducto);
        textViewCantidad = findViewById(R.id.textoCantidad);
        textViewPrecio = findViewById(R.id.textoPrecio);
        imageViewProducto = findViewById(R.id.imagenProducto);
        spinnerOpciones = findViewById(R.id.spinnerOpciones);

        Intent intent = getIntent();
        if (intent != null) {
            String nombreProducto = intent.getStringExtra("nombre_producto");
            String cantidad = intent.getStringExtra("cantidad");
            String precio = intent.getStringExtra("precio");
            int imagenProducto = intent.getIntExtra("imagen", 0);

            textViewNombreProducto.setText(nombreProducto);
            textViewCantidad.setText(cantidad);
            textViewPrecio.setText(precio);
            imageViewProducto.setImageResource(imagenProducto);
        }

        String[] opciones = {"Montt 242"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOpciones.setAdapter(adapter);

        spinnerOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String opcionSeleccionada = opciones[position];

                if (opcionSeleccionada.equals("Montt 242")) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        Button buttonVolver = findViewById(R.id.button4);
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActividadCarritoCompra.this, ActividadInicio.class);
                startActivity(intent);
            }
        });

        Button buttonFinalizarCompra = findViewById(R.id.button3);
        buttonFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActividadCarritoCompra.this, ActividadEnviodeProducto.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String nombreProducto = data.getStringExtra("nombre_producto");
            String cantidad = data.getStringExtra("cantidad");
            String precio = data.getStringExtra("precio");
            int imagenProducto = data.getIntExtra("imagen", 0);

            textViewNombreProducto.setText(nombreProducto);
            textViewCantidad.setText(cantidad);
            textViewPrecio.setText(precio);
            imageViewProducto.setImageResource(imagenProducto);
        }
    }
}
