package usa.sesion1.reto3_chaquetaapp.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import usa.sesion1.reto3_chaquetaapp.R;
import usa.sesion1.reto3_chaquetaapp.Vista.Fragment_Favoritos;
import usa.sesion1.reto3_chaquetaapp.Vista.Fragment_Inicio;
import usa.sesion1.reto3_chaquetaapp.Vista.Fragment_Productos;
import usa.sesion1.reto3_chaquetaapp.Vista.Fragment_Servicios;
import usa.sesion1.reto3_chaquetaapp.Vista.Fragment_Sucursales;

public class MainActivity extends AppCompatActivity {

    Fragment subPantalla1, subPantalla2, subPantalla3, subPantalla4, subPantallaInicio;
    FragmentTransaction intercambio;

    Button boton_ini, boton1, boton2, boton3, boton4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantalla1 = new Fragment_Productos();
        subPantalla2 = new Fragment_Servicios();
        subPantalla3 = new Fragment_Sucursales();
        subPantalla4 = new Fragment_Favoritos();
        subPantallaInicio = new Fragment_Inicio();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, subPantallaInicio).commit();

        boton_ini = (Button)findViewById(R.id.button_inicio);
        boton_ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subPantallaInicio).commit();
                Toast.makeText(getApplicationContext(), "Gracias por elegirnos", Toast.LENGTH_LONG).show();
            }
        });
        boton1 = (Button)findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
            }
        });

        boton2 = (Button)findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
            }
        });

        boton3 = (Button)findViewById(R.id.boton3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subPantalla3).commit();
            }
        });
    }

    //****************************************** MENU DE OPCIONES ***************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.button_inicio){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantallaInicio).commit();
        }
        if (id == R.id.productos){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
        }
        if (id == R.id.servicios){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
        }
        if (id == R.id.sucursales){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla3).commit();
        }
        if (id == R.id.boton4){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla4).commit();
        }
        return super.onOptionsItemSelected(item);
    }
    //*****************************************************************************************************************
}