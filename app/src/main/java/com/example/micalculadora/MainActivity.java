package com.example.micalculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText number1, number2;
    TextView result;
    Button add, subtract, multiply, divide, equals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de variables
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        add = findViewById(R.id.button_add);
        subtract = findViewById(R.id.button_subtract);
        multiply = findViewById(R.id.button_multiply);
        divide = findViewById(R.id.button_divide);
        equals = findViewById(R.id.button_equals);

        // Suma
        add.setOnClickListener(v -> {
            if (validateInputs()) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                int res = num1 + num2;
                result.setText(String.valueOf(res));
            }
        });

        // Resta
        subtract.setOnClickListener(v -> {
            if (validateInputs()) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                int res = num1 - num2;
                result.setText(String.valueOf(res));
            }
        });

        // Multiplicación
        multiply.setOnClickListener(v -> {
            if (validateInputs()) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                int res = num1 * num2;
                result.setText(String.valueOf(res));
            }
        });

        // División
        divide.setOnClickListener(v -> {
            if (validateInputs()) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                if (num2 != 0) {
                    int res = num1 / num2;
                    result.setText(String.valueOf(res));
                } else {
                    result.setText("Error: División por 0");
                }
            }
        });

        // Configuración de EdgeToEdge
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Método para validar la entrada
    private boolean validateInputs() {
        if (number1.getText().toString().isEmpty() || number2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese ambos números", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
