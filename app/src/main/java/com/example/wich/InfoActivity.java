package com.example.wich;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        String title="";

        Bundle extras = getIntent().getExtras();

        if(extras == null) {
            title = "error";
        }
        else {
            title = extras.getString("title");
        }

        Intent intent = getIntent();
        TextView textview = findViewById(R.id.textView);
        textview.setText(title);


        Button BReturn = (Button) findViewById(R.id.BRutton);

        BReturn.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
    finish();
    }
});
}
}