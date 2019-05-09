package com.evand.edu.uulalulintas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.evand.edu.uulalulintas.Database.DB;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB db = new DB(this);

        try {
            db.createDB();
            Log.i("Create DB>>>>>>>>>>>>>>>>>", "Success");
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        db.close();
    }

    public void btnoc1(View v){
        startActivity(new Intent(MainActivity.this, content.class));
    }
    public void btnoc2(View v){
        startActivity(new Intent(MainActivity.this, simulasi.class));
    }
    public void btnoc3(View v){
        startActivity(new Intent(MainActivity.this, rambu.class));
    }
    public void btnoc4(View v){
        startActivity(new Intent(MainActivity.this, tentang.class));
    }
}
