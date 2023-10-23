package com.example.farmaciamovil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadModificarProductoParace extends AppCompatActivity {

    private static final int GALLERY_REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadmodificarproductoparace);

        ImageView imageViewProducto = findViewById(R.id.imagenparace);
        imageViewProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirGaleria();
            }
        });

        Button buttonEliminarProducto = findViewById(R.id.buttonEliminarParace);
        buttonEliminarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irASeleccionarProducto();
            }
        });

        Button buttonGuardarCambios = findViewById(R.id.buttonGuardarCambiosParace);
        buttonGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irASeleccionarProducto();
            }
        });
    }

    private void abrirGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    private void irASeleccionarProducto() {
        Intent intent = new Intent(this, ActividadSeleccionarProducto.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            ImageView imageView = findViewById(R.id.imagenparace);
            imageView.setImageURI(selectedImage);
        }
    }
}
