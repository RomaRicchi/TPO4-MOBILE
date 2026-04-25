package com.roma.tpo4_movile.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.roma.tpo4_movile.MainActivity;
import com.roma.tpo4_movile.modelo.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListarViewModel extends ViewModel {

    private final MutableLiveData<List<Producto>> productos = new MutableLiveData<>();

    public LiveData<List<Producto>> getProductos() {
        return productos;
    }

    public void cargarProductos() {
        filtrar(""); // Por defecto carga todo
    }

    public void filtrar(String query) {
        ArrayList<Producto> listaFiltrada = new ArrayList<>();
        
        for (Producto p : MainActivity.listaProductos) {
            if (p.getDescripcion().toLowerCase().contains(query.toLowerCase())) {
                listaFiltrada.add(p);
            }
        }

        // Ordenar alfabéticamente por descripción
        Collections.sort(listaFiltrada, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion());
            }
        });

        productos.setValue(listaFiltrada);
    }
}
