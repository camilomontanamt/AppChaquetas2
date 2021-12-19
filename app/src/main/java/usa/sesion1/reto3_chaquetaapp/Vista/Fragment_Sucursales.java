package usa.sesion1.reto3_chaquetaapp.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

import usa.sesion1.reto3_chaquetaapp.R;

public class Fragment_Sucursales extends Fragment {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagen1, imagen2, imagen3;

    private MapView myOpenMapView;
    private MapController myMapController;

    GeoPoint Bogota, local1, local2, local3;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__sucursales, container, false);
        //-----------------------------------------------------------------------------

        myOpenMapView = (MapView) v.findViewById(R.id.openmapview);

        /* ---- necesitamos establecer el valor del agente de usuario en la configuración ------- */
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        /*   punto de geolocalizacion */
        Bogota = new GeoPoint(4.6351, -74.0703);
        local1 = new GeoPoint(4.641773, -74.073210);
        local2 = new GeoPoint(4.652362138456, -74.0715671812098);
        local3 = new GeoPoint(4.664104211843055, -74.05003633748231);

        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Bogota);
        myMapController.setZoom(6);

        myOpenMapView.setMultiTouchControls(true);

        /* -------------------------------------------------------------------------------------------------- */
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();

        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        /* -------------------------------------------------------------------------------------------------- */

        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Bogota", "Capital de Colombia", Bogota));
        puntos.add(new OverlayItem("Galerias", "Tienda 1", local1));
        puntos.add(new OverlayItem("Calle 23", "Tienda 2", local2));
        puntos.add(new OverlayItem("Calle 83", "Tienda 3", local3));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);

        //-----------------------------------------------------------------------------
        return v;
    }
}