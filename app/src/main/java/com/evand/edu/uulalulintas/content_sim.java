package com.evand.edu.uulalulintas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class content_sim extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_sim);
    }

    public void btnoc(View v){
        startActivity(new Intent(content_sim.this, sim.class));
    }
    public void btnoc2(View v){
        startActivity(new Intent(content_sim.this, sim2.class));
    }
}
