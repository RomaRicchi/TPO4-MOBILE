package com.roma.tpo4_movile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.roma.tpo4_movile.utilidades.Evento;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Evento<Boolean>> eventoMostrarDialogoSalir = new MutableLiveData<>();

    public LiveData<Evento<Boolean>> getEventoMostrarDialogoSalir() {
        return eventoMostrarDialogoSalir;
    }

    public void solicitarSalir() {
        eventoMostrarDialogoSalir.setValue(new Evento<>(true));
    }
}
