package com.roma.tpo4_movile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.roma.tpo4_movile.modelo.Producto;
import com.roma.tpo4_movile.utilidades.Evento;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Evento<Boolean>> eventoMostrarDialogoSalir = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Producto>> productosMutable = new MutableLiveData<>();

    public LiveData<Evento<Boolean>> getEventoMostrarDialogoSalir() {
        return eventoMostrarDialogoSalir;
    }

    public LiveData<ArrayList<Producto>> getProductosMutable() {
        return productosMutable;
    }

    public void cargarProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(101, "Teclado Mecánico RGB", 45000.50));
        listaProductos.add(new Producto(102, "Mouse Gamer 16000 DPI", 25000.00));
        listaProductos.add(new Producto(103, "Monitor 24' Full HD", 120000.99));
        productosMutable.setValue(listaProductos);
    }

    public void solicitarSalir() {
        eventoMostrarDialogoSalir.setValue(new Evento<>(true));
    }
}
