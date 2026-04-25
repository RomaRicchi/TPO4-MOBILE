package com.roma.tpo4_movile.ui.cargar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.roma.tpo4_movile.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        vm = new ViewModelProvider(this).get(CargarViewModel.class);

        configurarListeners();
        observarEstado();

        return binding.getRoot();
    }

    private void configurarListeners() {
        binding.btnCargar.setOnClickListener(v -> {
            String codigo = binding.etCodigo.getText().toString();
            String descripcion = binding.etDescripcion.getText().toString();
            String precio = binding.etPrecio.getText().toString();
            vm.cargarProducto(codigo, descripcion, precio);
        });
    }

    private void observarEstado() {
        vm.getMensaje().observe(getViewLifecycleOwner(), evento -> {
            String msg = evento.obtenerContenidoSiNoSidoManejado();
            if (msg != null) {
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        vm.getEventoLimpiarCampos().observe(getViewLifecycleOwner(), evento -> {
            if (evento.obtenerContenidoSiNoSidoManejado() != null) {
                binding.etCodigo.setText("");
                binding.etDescripcion.setText("");
                binding.etPrecio.setText("");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
