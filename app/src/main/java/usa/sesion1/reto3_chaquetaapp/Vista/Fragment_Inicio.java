package usa.sesion1.reto3_chaquetaapp.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import usa.sesion1.reto3_chaquetaapp.R;

public class Fragment_Inicio extends Fragment {


    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__inicio, container, false);
        //__________________________________________________________________________________________


        //__________________________________________________________________________________________
        return view;
    }
}