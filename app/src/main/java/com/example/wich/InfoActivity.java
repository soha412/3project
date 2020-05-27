package com.example.wich;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        TextView textView = (TextView) findViewById(R.id.textView);
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView);

        if(title.equals("sungkyulUVI")) {
            textView.setText("성결대학교 입니다");
            imageView1.setImageResource(R.drawable.cafewel);
        }
        if(title.equals("Long Coffee")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("EDIYA")) {
            textView.setText(" EDIYA ");
            imageView1.setImageResource(R.drawable.ediya);
        }
        // 나머지 카페 복붙


        Button Revturn = (Button) findViewById(R.id.RevButton);
        Button BReturn = (Button) findViewById(R.id.BRutton);

        BReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Revturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentview = new Intent(getApplicationContext(),ReView.class);
                startActivity(intentview);
            }
        });
}
}