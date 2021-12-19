package usa.sesion1.reto3_chaquetaapp.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* ====================================================================================================== */
        //TABLA FAVORITOS
        db.execSQL("CREATE TABLE favoritos (id INT, titulo TEXT,descripcion TEXT)");
        //---- Registros


        /* ====================================================================================================== */
        //TABLA PRODUCTOS
        db.execSQL("CREATE TABLE productos (imagen INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO productos VALUES ( 0, 'Chaquetas para hombre','PAra todas las Ocaciones')");
        db.execSQL("INSERT INTO productos VALUES ( 1, 'Chaquetas para Mujer','Todos los Estilos')");
        db.execSQL("INSERT INTO productos VALUES ( 2, 'Chaquetas Personalizadas','Trae tu diseño')");

        /* ====================================================================================================== */
        //TABLA SERVICIOS
        db.execSQL("CREATE TABLE servicios (titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO servicios VALUES ('Domicilios','Dentro y fuera de la ciudad')");
        db.execSQL("INSERT INTO servicios VALUES ('Promociones','Toodos los días')");
        db.execSQL("INSERT INTO servicios VALUES ('Dotaciones para Empresas','Fabricamos para empresas a nivel nacional')");
        /* ====================================================================================================== */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);

    }
}
