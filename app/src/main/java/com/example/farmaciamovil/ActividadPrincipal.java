package com.example.farmaciamovil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.farmaciamovil.ActividadInicio;
import com.example.farmaciamovil.R;

public class ActividadPrincipal extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button botonIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadprincipal);


        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        botonIniciarSesion = findViewById(R.id.iniciarsesion);


        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = editTextEmail.getText().toString();
                String contrasena = editTextPassword.getText().toString();


                if (usuario.equals("Joacorrego") && contrasena.equals("12345678")) {

                    Intent intent = new Intent(ActividadPrincipal.this, ActividadInicio.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(ActividadPrincipal.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });


        TextView textViewRegister = findViewById(R.id.textViewRegister);
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToRegister();
            }
        });


        TextView textViewRecuperarContrasena = findViewById(R.id.textViewRecuperarContrasena);
        textViewRecuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToPasswordReset();
            }
        });


        TextView textViewAdmin = findViewById(R.id.textViewAdmin);
        textViewAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToAdmin();
            }
        });
    }


    public void goToRegister() {

        Intent intent = new Intent(this, ActividadRegistro.class);
        startActivity(intent);
    }


    public void goToPasswordReset() {

        Intent intent = new Intent(this, ActividadRestablecerContrasena.class);
        startActivity(intent);
    }


    public void goToAdmin() {

        Intent intent = new Intent(this, ActividadAdministrador.class);
        startActivity(intent);
    }


}



















