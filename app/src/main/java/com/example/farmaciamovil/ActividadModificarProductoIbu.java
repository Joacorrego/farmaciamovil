package com.example.farmaciamovil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadModificarProductoIbu extends AppCompatActivity {

    private static final int GALLERY_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadmodifcarproductoibu);


        ImageView imageViewProducto = findViewById(R.id.ibufoto);
        imageViewProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirGaleria();
            }
        });


        Button buttonEliminar = findViewById(R.id.buttonEliminar);
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActividadModificarProductoIbu.this, ActividadSeleccionarProducto.class);
                startActivity(intent);
            }
        });


        Button buttonGuardarCambios = findViewById(R.id.buttonGuardarCambios);
        buttonGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActividadModificarProductoIbu.this, ActividadSeleccionarProducto.class);
                startActivity(intent);
            }
        });
    }


    private void abrirGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();

            ImageView imageViewProducto = findViewById(R.id.ibufoto);
            imageViewProducto.setImageURI(selectedImage);
        }
    }
}
