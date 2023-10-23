package com.example.farmaciamovil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ActividadInicio extends AppCompatActivity {

    private EditText editTextBuscar;
    private RecyclerView recyclerViewResultados;
    private ProductoAdapter productoAdapter;
    private List<Producto> listaProductos;
    private List<Producto> resultadosBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadinicio);

        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Ibuprofeno", "ibuprofeno.png", 10, 1000));
        listaProductos.add(new Producto("Paracetamol", "paracetamol.png", 20, 600));

        resultadosBusqueda = new ArrayList<>();

        editTextBuscar = findViewById(R.id.editTextBuscar);
        recyclerViewResultados = findViewById(R.id.recyclerViewResultados);

        recyclerViewResultados.setLayoutManager(new LinearLayoutManager(this));
        productoAdapter = new ProductoAdapter(resultadosBusqueda, this);
        recyclerViewResultados.setAdapter(productoAdapter);

        editTextBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String textoBusqueda = charSequence.toString();
                buscarResultados(textoBusqueda);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        ImageView imageView11 = findViewById(R.id.imageView11);
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadInicio.this, ActividadMisDirecciones.class);
                startActivity(intent);
            }
        });

        ImageView imageView16 = findViewById(R.id.imageView16);
        imageView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadInicio.this, ActividadInformacionPersonal.class);
                startActivity(intent);
            }
        });

        TextView textViewVolver = findViewById(R.id.textViewVolver);
        textViewVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadInicio.this, ActividadPrincipal.class);
                startActivity(intent);
            }
        });
    }

    private void buscarResultados(String textoBusqueda) {
        resultadosBusqueda.clear();

        if (textoBusqueda.isEmpty()) {
            productoAdapter.notifyDataSetChanged();
            return;
        }

        for (Producto producto : listaProductos) {
            if (producto.getNombre().toLowerCase().contains(textoBusqueda.toLowerCase())) {
                resultadosBusqueda.add(producto);
            }
        }

        productoAdapter.notifyDataSetChanged();
    }

    public static class Producto {
        private String nombre;
        private String imagen;
        private int cantidad;
        private double valor;

        public Producto(String nombre, String imagen, int cantidad, double valor) {
            this.nombre = nombre;
            this.imagen = imagen;
            this.cantidad = cantidad;
            this.valor = valor;
        }

        public String getNombre() {
            return nombre;
        }

        public String getImagen() {
            return imagen;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getValor() {
            return valor;
        }
    }
}
