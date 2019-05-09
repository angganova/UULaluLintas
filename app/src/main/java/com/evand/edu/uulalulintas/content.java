package com.evand.edu.uulalulintas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class content extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }

    public void btnoc(View v){
        startActivity(new Intent(content.this, r2.class));
    }
    public void btnoc2(View v){
        startActivity(new Intent(content.this, r4.class));
    }
}
