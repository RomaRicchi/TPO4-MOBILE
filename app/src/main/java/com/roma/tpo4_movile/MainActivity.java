package com.roma.tpo4_movile;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.roma.tpo4_movile.databinding.ActivityMainBinding;
import com.roma.tpo4_movile.modelo.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Lista estática de productos
    public static ArrayList<Producto> listaProductos = new ArrayList<>();
    
    private ActivityMainBinding binding;
    private AppBarConfiguration mAppBarConfiguration;
    private MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Precargar productos si la lista está vacía (evita duplicados si la actividad se recrea)
        if (listaProductos.isEmpty()) {
            listaProductos.add(new Producto(101, "Teclado Mecánico RGB", 45000.50));
            listaProductos.add(new Producto(102, "Mouse Gamer 16000 DPI", 25000.00));
            listaProductos.add(new Producto(103, "Monitor 24' Full HD", 120000.99));
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(MainViewModel.class);

        setSupportActionBar(binding.appBarMain.toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
        NavController navController = navHostFragment.getNavController();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_cargar, R.id.nav_listar)
                .setOpenableLayout(binding.drawerLayout)
                .build();
        
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        
        if (binding.navView != null) {
            NavigationUI.setupWithNavController(binding.navView, navController);

            binding.navView.setNavigationItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_salir) {
                    vm.solicitarSalir();
                } else {
                    boolean handled = NavigationUI.onNavDestinationSelected(item, navController);
                    if (handled && binding.drawerLayout != null) {
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    return handled;
                }
                if (binding.drawerLayout != null) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            });
        }

        observarEventos();
    }

    private void observarEventos() {
        vm.getEventoMostrarDialogoSalir().observe(this, evento -> {
            if (evento.obtenerContenidoSiNoSidoManejado() != null) {
                mostrarDialogoSalir();
            }
        });
    }

    private void mostrarDialogoSalir() {
        new AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Desea cerrar la aplicacion?")
                .setPositiveButton("Si", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main));
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
