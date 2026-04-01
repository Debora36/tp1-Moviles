package com.debora.conversor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private float uneuro=0.86f;
    private MutableLiveData <Float> UnEuro;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        UnEuro = new MutableLiveData<>();
        UnEuro.setValue(uneuro);
    }

    public LiveData<Float> getUnEuro(){
        return UnEuro;
    }
    public void setUnEuro(float nuevoValor) {
        if (UnEuro != null) {
            UnEuro.setValue(nuevoValor);
        }
    }

    public float convertirADolar(float euro){
        Float valorActual=UnEuro.getValue();
        return euro/valorActual;
    }
    public float convertirAEuro(float dolar){
        Float valorActual=UnEuro.getValue();
        return dolar*valorActual;
    }



}

