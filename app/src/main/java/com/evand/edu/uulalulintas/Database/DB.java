package com.evand.edu.uulalulintas.Database;

/**
 * Created by ACER on 25/12/2014.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.evand.edu.uulalulintas.Simulasi.Question;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class DB extends SQLiteOpenHelper {


    private static String DB_PATH = "data/data/com.evand.edu.uulalulintas/databases/";
    private static String DB_NAME = "Database";
    private static String TABLE_R2 = "datapasalR2";
    private static String TABLE_R4 = "datapasalR4";
    private static String TABLE_SIM = "simulasi";
    private static String TABLE_SIM2 = "simulasi2";
    private final Context context;
    private static SQLiteDatabase db;
    public static final String COLUMN_NO = "no";
    public static final String COLUMN_PELANGGARAN = "pelanggaran";
    public static final String COLUMN_PASAL = "pasal";
    public static final String COLUMN_SANKSI = "sanksi";
    private static final String[] allColumns = {COLUMN_NO,
            COLUMN_PELANGGARAN, COLUMN_PASAL, COLUMN_SANKSI};

    public DB(Context context) {

        super( context , DB_NAME , null , 1);
        this.context = context;

    }


    public void createDB() throws IOException {

        this.getReadableDatabase();

        try {

            copyDB();

        } catch (IOException e) {

            throw new Error("Error copying database");

        }
    }



    public void copyDB() throws IOException {

        try {

            Log.i("Copy DB", "Start");


            InputStream ip = context.getAssets().open(DB_NAME + ".db");

            Log.i("Input Stream....", ip + "");

            String op = DB_PATH + DB_NAME;

            OutputStream output = new FileOutputStream(op);

            byte[] buffer = new byte[1024];

            int length;

            while ((length = ip.read(buffer)) > 0) {

                output.write(buffer, 0, length);

            }

            output.flush();

            output.close();

            ip.close();

        } catch (IOException e) {

            Log.v("error", e.toString());

        }
    }


    public boolean openDB() {

        try {
            String myPath = DB_PATH + DB_NAME;
            db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
            return true;


        } catch (SQLException sqle) {
            db = null;
            return false;
        }

    }

    @Override
    public synchronized void close() {

        if (db != null)
            db.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    // DATA PASAL DAN SANKSI KENDARAAN RODA 2
    private static R2pasal cursorToPasalR2(Cursor c) {

        R2pasal r2pasal = new R2pasal();
        r2pasal.setPelanggaran(c.getString(1));
        r2pasal.setSanksi(c.getString(2));
        r2pasal.setPasal(c.getString(3));


        return r2pasal;
    }

    public static ArrayList<R2pasal> getAllPasalR2() {
        ArrayList<R2pasal> daftarPasal = new ArrayList<R2pasal>();


        Cursor cursor = db.query(DB.TABLE_R2,
                allColumns, null, null, null, null, null);


        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            R2pasal r2pasal = cursorToPasalR2(cursor);
            daftarPasal.add(r2pasal);
            cursor.moveToNext();

        }

        cursor.close();
        db.close();
        return daftarPasal;
    }

    // DATA PASAL DAN SANKSI KENDARAAN RODA 4
    private static R4pasal cursorToPasalR4(Cursor c) {

        R4pasal r4pasal = new R4pasal();
        r4pasal.setNo(c.getLong(0));
        r4pasal.setPelanggaran(c.getString(1));
        r4pasal.setSanksi(c.getString(2));
        r4pasal.setPasal(c.getString(3));


        return r4pasal;
    }

    public static ArrayList<R4pasal> getAllPasalR4() {
        ArrayList<R4pasal> daftarPasal = new ArrayList<R4pasal>();


        Cursor cursor = db.query(DB.TABLE_R4,
                allColumns, null, null, null, null, null);


        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            R4pasal r4pasal = cursorToPasalR4(cursor);
            daftarPasal.add(r4pasal);
            cursor.moveToNext();

        }

        cursor.close();
        db.close();
        return daftarPasal;
    }



    //SIMULASI BERKENDARA RODA2
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT  * FROM " + TABLE_SIM;
        db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return quesList;
    }

    //SIMULASI BERKENDARA RODA 4 / LEBIH
    public List<Question> getAllQuestions2() {
        List<Question> quesList = new ArrayList<Question>();
        String selectQuery = "SELECT  * FROM " + TABLE_SIM2;
        db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return quesList;
    }
}
