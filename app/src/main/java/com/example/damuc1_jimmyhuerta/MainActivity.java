package com.example.damuc1_jimmyhuerta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los componentes del XML
        EditText nombre = findViewById(R.id.nombre);
        EditText apellido = findViewById(R.id.apellido);
        EditText correo = findViewById(R.id.correo);
        EditText password = findViewById(R.id.password);
        Spinner diaSpinner = findViewById(R.id.dia);
        Spinner mesSpinner = findViewById(R.id.mes);
        Spinner anioSpinner = findViewById(R.id.anio);
        RadioGroup generoGroup = findViewById(R.id.genero);
        Button registrarButton = findViewById(R.id.registrar);

        // Acción al presionar el botón "Registrarte"
        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados por el usuario
                String nombreText = nombre.getText().toString();
                String apellidoText = apellido.getText().toString();
                String correoText = correo.getText().toString();
                String passwordText = password.getText().toString();

                // Obtener la fecha de nacimiento (día, mes, año)
                String dia = diaSpinner.getSelectedItem().toString();
                String mes = mesSpinner.getSelectedItem().toString();
                String anio = anioSpinner.getSelectedItem().toString();
                String fechaNacimiento = dia + " " + mes + " " + anio;

                // Obtener el género seleccionado
                int selectedGenderId = generoGroup.getCheckedRadioButtonId();
                RadioButton selectedGenderButton = findViewById(selectedGenderId);
                String genero = selectedGenderButton != null ? selectedGenderButton.getText().toString() : "No seleccionado";

                // Validaciones básicas
                if (nombreText.isEmpty() || apellidoText.isEmpty() || correoText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí se pueden procesar los datos o realizar una acción con ellos
                    String resumen = "Nombre: " + nombreText + "\n" +
                            "Apellido: " + apellidoText + "\n" +
                            "Correo: " + correoText + "\n" +
                            "Contraseña: " + passwordText + "\n" +
                            "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                            "Género: " + genero;

                    // Mostrar un mensaje de éxito con los datos ingresados
                    Toast.makeText(MainActivity.this, resumen, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}