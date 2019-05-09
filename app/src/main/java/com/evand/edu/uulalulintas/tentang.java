package com.evand.edu.uulalulintas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class tentang extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
    }

    public void btnoc1(View v){
        startActivity(new Intent(tentang.this, bantuan.class));
    }

    public void btnoc2(View v){
        startActivity(new Intent(tentang.this, pembuat.class));
    }

}
