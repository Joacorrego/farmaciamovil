package com.example.farmaciamovil;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadRegistro extends AppCompatActivity {

    private EditText editTextEmail, editTextUsername, editTextPassword, editTextRepeatPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividadregistro);


        editTextEmail = findViewById(R.id.editTextRegisterEmail);
        editTextUsername = findViewById(R.id.editTextRegisterUsername);
        editTextPassword = findViewById(R.id.editTextRegisterPassword);
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword);
        buttonRegister = findViewById(R.id.buttonRegister);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editTextEmail.getText().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String repeatPassword = editTextRepeatPassword.getText().toString();


                if (email.isEmpty() || username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
                    Toast.makeText(ActividadRegistro.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(repeatPassword)) {
                    Toast.makeText(ActividadRegistro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                } else {

                    SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email", email);
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();

                    Toast.makeText(ActividadRegistro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();


                    finish();
                }
            }
        });
    }
}
