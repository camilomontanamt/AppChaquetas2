package usa.sesion1.reto3_chaquetaapp.Vista;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import usa.sesion1.reto3_chaquetaapp.Modelo.Adaptador;
import usa.sesion1.reto3_chaquetaapp.Modelo.BaseDatos.MotorBaseDatosSQLite;
import usa.sesion1.reto3_chaquetaapp.Modelo.Entidad;
import usa.sesion1.reto3_chaquetaapp.R;

public class Fragment_Productos extends Fragment {


    int [] imagen = {R.drawable.notes, R.drawable.p2, R.drawable.taxi };

    String TAG = "Fragment_Productos";

    View v;

    ListView listaProductos;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__productos, container, false);
        //-----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(getTablaProductos(), getContext());

        listaProductos.setAdapter(adaptador);


        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM productos", null);
        Log.v(TAG, "leyendo bas de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "dentro de while");
            listaProductos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(0), cursor.getString(1)));
            Log.v(TAG, "despues del while");
        }


        return listaProductos;
    }
    private ArrayList<Entidad> GetListItems(){
        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(R.drawable.cha1, "Chaquetas para Hombre", "Para todo tipo de Ocación"));
        listaItems.add(new Entidad(R.drawable.p2, "Chaquetas para Dama", "Todos los Estilos"));
        listaItems.add(new Entidad(R.drawable.p3, "Chaquetas Personalizadas", "El diseño que tú quieras"));
        return listaItems;
    }


}