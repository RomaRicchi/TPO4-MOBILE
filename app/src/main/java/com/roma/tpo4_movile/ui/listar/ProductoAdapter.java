package com.roma.tpo4_movile.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.roma.tpo4_movile.databinding.ItemProductoBinding;
import com.roma.tpo4_movile.modelo.Producto;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private List<Producto> lista;

    public ProductoAdapter(List<Producto> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductoBinding binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = lista.get(position);
        holder.binding.tvCodigo.setText("Cod: " + producto.getCodigo());
        holder.binding.tvDescripcion.setText(producto.getDescripcion());
        holder.binding.tvPrecio.setText("$" + producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        ItemProductoBinding binding;

        public ProductoViewHolder(@NonNull ItemProductoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
