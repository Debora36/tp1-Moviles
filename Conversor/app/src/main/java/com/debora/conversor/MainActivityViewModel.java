package com.debora.conversor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private float uneuro=0.86f; //valor de 1 euro por defecto
    //LiveData nuevos para guardar los resultados de las cuentas
    private MutableLiveData<Float> resultadoDolar;
    private MutableLiveData<Float> resultadoEuro;
    private MutableLiveData <Float> UnEuro;//Mutable que guarda valor actual de conversión y avisa si cambia
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        UnEuro = new MutableLiveData<>();
        UnEuro.setValue(uneuro);
        resultadoDolar = new MutableLiveData<>();
        resultadoEuro = new MutableLiveData<>();
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

    public MutableLiveData<Float> getResultadoEuro() {
        return resultadoEuro;
    }

    public MutableLiveData<Float> getResultadoDolar() {
        return resultadoDolar;
    }

    // Convertir un monto a dolar o a euro segun el boolean
    public void convertir(float monto, boolean aDolar){
        Float valorActual=UnEuro.getValue();

        if (aDolar){//Convertir euros a dolares
            resultadoDolar.setValue(monto/valorActual);
        }else{//Convertir Dolar a Euros
            resultadoEuro.setValue(monto*valorActual);
        }
    }



}

