package com.evand.edu.uulalulintas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Splash extends Activity {

    private static String TAG = Splash.class.getName();
    private static long SLEEP_TIME = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
    }

    private class IntentLauncher extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(SLEEP_TIME*1000);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }


            Intent intent = new Intent(Splash.this, MainActivity.class);
            Splash.this.startActivity(intent);
            Splash.this.finish();
        }
    }
}