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
import android.widget.TextView;
import com.evand.edu.uulalulintas.Database.DB;
import com.evand.edu.uulalulintas.Database.R2adt;
import com.evand.edu.uulalulintas.Database.R2pasal;

public class r2 extends Activity {

    ListView list;
    R2adt adapter;
    TextView editsearch;
    ImageButton btnsearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r2);
        DB db = new DB(this);
        try {
            db.openDB();
            Log.i("Open DB>>>>>>>>>>>>>>>>>", "Success");
        }catch(SQLException sqle){
            throw sqle;
        }

        list = (ListView) findViewById(R.id.listview);
        ArrayList<R2pasal> values = DB.getAllPasalR2();
        adapter = new R2adt(this, values);
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
                if (text.length() == 0 ) {
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
        getMenuInflater().inflate(R.menu.menu_r2, menu);
        return true;
    }


}