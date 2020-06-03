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
        if(title.equals("Hollis Coffee")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("Can Coffee")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("6th street Coffee Shop")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("TwoSome Place")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("mumus Cafe")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("KKun Fishing Cafe")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("Coffee GruNamu")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("Palk's Coffee")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("Coffee GruNamu")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("Cafe Bianco")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("쏠렌자라")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("파스쿠찌 명학점")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("엔제리너스")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("좋은사람들")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("커피 본")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("커피 베이")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("향기가 머무는 커피숍")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }
        if(title.equals("카페하로")) {
            textView.setText(" 맛있는 롱커피 입니다");
        }





        Button Revturn = (Button) findViewById(R.id.RevButton);
        Button BReturn = (Button) findViewById(R.id.BRutton);

        BReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });  // 뒤로가기

        Revturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {        // 리뷰 보기
                Intent intentview = new Intent(getApplicationContext(),ReView.class);
                startActivity(intentview);
            }
        });
}
}