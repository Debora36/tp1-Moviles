package com.debora.conversor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private float uneuro=0.86f; //valor de 1 euro por defecto
    private MutableLiveData <Float> UnEuro;//Mutable que guarda valor actual de conversión y avisa si cambia
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        UnEuro = new MutableLiveData<>();
        UnEuro.setValue(uneuro);
    }

    public LiveData<Float> getUnEuro(){
        return UnEuro;
    }
    // Cambiar el valor de conversión
    public void setUnEuro(float nuevoValor) {
        if (UnEuro != null) {
            UnEuro.setValue(nuevoValor);
        }
    }

    // Convertir un monto a dolar o a euro segun el boolean
    public float convertir(float monto, boolean aDolar){
        Float valorActual=UnEuro.getValue();
        Float resultado;
        if (aDolar){//Convertir euros a dolares
            resultado=monto/valorActual;
        }else{//Convertir Dolar a Euros
            resultado=monto*valorActual;
        }
        return resultado;
    }



}

