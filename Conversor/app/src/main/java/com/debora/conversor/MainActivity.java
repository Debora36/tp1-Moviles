package com.debora.conversor;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.debora.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;//para conectar la vista
    private MainActivityViewModel mv;//para conectar con el ViewModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());//devuelve el contenedor de la vista
        mv= new ViewModelProvider(this).get(MainActivityViewModel.class);//inicializa el viewmodel
        //OBSERVADORES
        mv.getResultadoDolar().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(Float resultado) {
                binding.etDolar.setText(String.valueOf(resultado));
            }
        });
        mv.getResultadoEuro().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(Float resultado) {
                binding.etEuro.setText(String.valueOf(resultado));
            }
        });
        //BOTÓN "CAMBIAR VALOR"
        //cuando le das click cambia el nombre a guardar y se habilita el campo para que el usuario cambie el numero y vuelva a dar click en el boton para guardar

        binding.btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.etUnEuro.isEnabled()){
                    binding.etUnEuro.setEnabled(true);
                    binding.btnCambiar.setText("Guardar");
                }
                else{//Ya esta habilitado el edit text para cambiar el valor
                    mv.setUnEuro(Float.parseFloat(binding.etUnEuro.getText().toString()));
                    binding.etUnEuro.setEnabled(false);//Vuelvo a bloquear el campo
                    binding.btnCambiar.setText("Cambiar valor");
                }
            }
        });

        //BOTÓN "CONVERTIR"
        binding.btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.rbConvertirADolar.isChecked()){//Si el usuario marcó "Convertir a Dólares"
                    String textoEuros=binding.etEuro.getText().toString();//recupero el monto de euros
                    if (!textoEuros.isEmpty()){//corroboro que no haya estado vacio
                        mv.convertir(Float.parseFloat(textoEuros), true);//llamo al metodo pero pasando el valor a float
                    }
                }
                else{//si marcó la opción de ""convertir a euros" uso la misma lógica
                    String textoDolar = binding.etDolar.getText().toString();
                    if (!textoDolar.isEmpty()){
                        mv.convertir(Float.parseFloat(textoDolar), false);
                    }
                }
            }
        });
    }
}