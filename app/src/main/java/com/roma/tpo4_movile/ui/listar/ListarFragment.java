package com.roma.tpo4_movile.ui.listar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.roma.tpo4_movile.databinding.FragmentListarBinding;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListarBinding.inflate(inflater, container, false);
        vm = new ViewModelProvider(this).get(ListarViewModel.class);

        binding.rvProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        vm.getProductos().observe(getViewLifecycleOwner(), productos -> {
            ProductoAdapter adapter = new ProductoAdapter(productos);
            binding.rvProductos.setAdapter(adapter);
        });

        // Listener para la búsqueda en tiempo real
        binding.etBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                vm.filtrar(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        vm.cargarProductos();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
