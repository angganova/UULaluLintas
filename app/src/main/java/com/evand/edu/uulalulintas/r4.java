package com.evand.edu.uulalulintas;

import java.util.ArrayList;
import java.util.Locale;
import android.database.SQLException;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.evand.edu.uulalulintas.Database.DB;
import com.evand.edu.uulalulintas.Database.R4adt;
import com.evand.edu.uulalulintas.Database.R4pasal;

public class r4 extends Activity {

    ListView list;
    R4adt adapter;
    EditText editsearch;
    ImageButton btnsearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r4);
        DB db = new DB(this);

        try {
            db.openDB();
            Log.i("Open DB>>>>>>>>>>>>>>>>>", "Success");
        }catch(SQLException sqle){
            throw sqle;
        }

        list = (ListView) findViewById(R.id.listview);
        ArrayList<R4pasal> values = DB.getAllPasalR4();
        adapter = new R4adt(this, values);
        list.setAdapter(adapter);
        list.setAdapter(adapter);
        editsearch = (EditText) findViewById(R.id.search);
        btnsearch = (ImageButton) findViewById(R.id.btncari);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);

            }
        });
        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {

                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                if (text.length() == 0) {
                    adapter.filter("");
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {

            }
        });

        db.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_r4, menu);
        return true;
    }


}