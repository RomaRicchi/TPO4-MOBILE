package com.roma.tpo4_movile.ui.cargar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.roma.tpo4_movile.MainActivity;
import com.roma.tpo4_movile.modelo.Producto;
import com.roma.tpo4_movile.utilidades.Evento;

public class CargarViewModel extends ViewModel {

    private final MutableLiveData<Evento<String>> mensaje = new MutableLiveData<>();
    private final MutableLiveData<Evento<Boolean>> eventoLimpiarCampos = new MutableLiveData<>();

    public LiveData<Evento<String>> getMensaje() {
        return mensaje;
    }

    public LiveData<Evento<Boolean>> getEventoLimpiarCampos() {
        return eventoLimpiarCampos;
    }

    public void cargarProducto(String codigoStr, String descripcion, String precioStr) {
        if (codigoStr.isEmpty() || descripcion.isEmpty() || precioStr.isEmpty()) {
            mensaje.setValue(new Evento<>("Todos los campos son obligatorios"));
            return;
        }

        try {
            int codigo = Integer.parseInt(codigoStr);
            double precio = Double.parseDouble(precioStr);

            for (Producto p : MainActivity.listaProductos) {
                if (p.getCodigo() == codigo) {
                    mensaje.setValue(new Evento<>("El codigo ya existe"));
                    return;
                }
            }

            Producto nuevo = new Producto(codigo, descripcion, precio);
            MainActivity.listaProductos.add(nuevo);

            mensaje.setValue(new Evento<>("Producto cargado correctamente"));
            eventoLimpiarCampos.setValue(new Evento<>(true));

        } catch (NumberFormatException e) {
            mensaje.setValue(new Evento<>("Codigo o precio invalidos"));
        }
    }
}
