package com.example.wich;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class intro extends AppCompatActivity {
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
}
    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(r, 2000);
    }

}
