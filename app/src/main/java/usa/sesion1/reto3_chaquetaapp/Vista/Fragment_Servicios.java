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


public class Fragment_Servicios extends Fragment {

    String TAG = "Fragment_Servicios";

    View v;

    ListView listaServicios;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        //-----------------------------------------------------------------------------
        listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(getTablaServicios(), getContext());

        listaServicios.setAdapter(adaptador);

        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaServicios(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM servicios", null);
        Log.v(TAG, "leyendo bas de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "dentro de while");
            listaProductos.add(new Entidad(R.drawable.create, cursor.getString(0), cursor.getString(1)));
            Log.v(TAG, "despues del while");
        }


        return listaProductos;
    }
    private ArrayList<Entidad> GetArrayItems(){
        ArrayList<Entidad> listaItems = new ArrayList<Entidad>();
        listaItems.add(new Entidad(R.drawable.notes, "Domicilios", "LLevamos tus productos a cualquier lugar del País"));
        listaItems.add(new Entidad(R.drawable.taxi, "Promociones", "Pregunta todos los días por nuestras Promociones"));
        listaItems.add(new Entidad(R.drawable.create, "Reparación", "Trae tus productos usados y aquí te los dejamos como Nuevos"));

        return listaItems;
    }
}