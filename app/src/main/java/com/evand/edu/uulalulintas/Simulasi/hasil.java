package com.evand.edu.uulalulintas.Simulasi;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.evand.edu.uulalulintas.MainActivity;
import com.evand.edu.uulalulintas.R;
import com.evand.edu.uulalulintas.content_sim;

public class hasil extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        TextView t=(TextView)findViewById(R.id.textResult);
        TextView tvs=(TextView)findViewById(R.id.tvscore);
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        String score2= String.valueOf(b.getInt("score2"));

        tvs.setText(score2);
        switch (score)
        {
            case 1:
            case 2:
            case 3:
            case 4:t.setText("Maaf Anda Tidak Lulus! " +
                    "Belajarlah lagi cara berkendara dengan tertib!");
                break;
            case 5:
            case 6:t.setText("Anda Hampir Lulus! " +
                    "Belajarlah lagi cara berkendara dengan tertib!");
                break;
            case 7:
            case 8:
            case 9:t.setText("Selamat Anda Lulus! " +
                    "Pertahankan cara berkendara anda dengan tertib!");
                break;
            case 10:t.setText("Selamat Anda Lulus Dengan Skor Maksimal! " +
                    "Pertahankan cara berkendara anda dengan tertib!!!");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_hasil, menu);
        return true;
    }
}