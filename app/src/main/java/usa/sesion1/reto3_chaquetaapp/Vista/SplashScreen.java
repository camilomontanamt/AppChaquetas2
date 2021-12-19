package usa.sesion1.reto3_chaquetaapp.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import usa.sesion1.reto3_chaquetaapp.Controlador.MainActivity;
import usa.sesion1.reto3_chaquetaapp.R;

public class SplashScreen extends AppCompatActivity implements Runnable{
    Thread h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView chaqueta = (ImageView)findViewById(R.id.chaqueta);
        chaqueta.setImageResource(R.drawable.jacket);

        //***********************
        h1= new Thread(this);
        h1.start();
        //***********************
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            Intent cambioPantalla = new Intent(getApplicationContext(), MainActivity.class );
            startActivity(cambioPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}