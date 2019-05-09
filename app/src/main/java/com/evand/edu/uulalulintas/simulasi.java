package com.evand.edu.uulalulintas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class simulasi extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulasi);
    }
    public void btnoc(View v){
        startActivity(new Intent(simulasi.this, content_sim.class));
    }
}
