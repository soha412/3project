package com.example.wich;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.InputStream;

public class ReView extends AppCompatActivity {

    private static final int REQUEST_CODE = 0 ;
    private DbHelper helper;
    private SQLiteDatabase db;
    String tag = "SQLite";

    EditText reviewin;
    EditText cafetitle;
    EditText TitleResult;
    EditText ViewResult;
    Button ipButton;
    Button opButton;

    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

       // ratingB = findViewById(R.id.rating);
      //  ratingResult = findViewById(R.id.ratingResult);

        reviewin = findViewById(R.id.reviewin);
        cafetitle = findViewById(R.id.cafetitle);
        TitleResult = findViewById(R.id.TitleResult);
        ViewResult = findViewById(R.id.ViewResult);
        imageView = findViewById(R.id.imageView);
        ipButton = findViewById(R.id.ipButton);  // input
        opButton = findViewById(R.id.opButton);  // output

        // 데이터베이스 헬퍼 정의

        helper = new DbHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }


            // 기존 데이터를 가진 테이블 삭제
           helper.onUpgrade(db,1,2);


        ipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inview = reviewin.getText().toString();
                String Title = cafetitle.getText().toString();
                db = helper.getWritableDatabase();

                db.execSQL("INSERT INTO contacts VALUES(null,'" + inview + "','" + Title + "');");

                Toast.makeText(getApplicationContext(),"입력완료",Toast.LENGTH_SHORT).show();

                reviewin.setText("");
                cafetitle.setText("");


                db.close();
            }
        });

        // 저장된 DB 출력
        opButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = helper.getReadableDatabase();
                Cursor cursor;
                cursor = db.rawQuery(" SELECT * FROM contacts; ",null);

                String strTitle = "제목" + "\r\n" + "---------" + "\r\n";
                String strReview = "내용" + "\r\n" + "---------" + "\r\n";


                while (cursor.moveToNext()) {
                    strTitle += cursor.getString(2) + "\r\n";
                    strReview += cursor.getString(1) + "\r\n";
                }

                TitleResult.setText(strTitle);
                ViewResult.setText(strReview);

                cursor.close();
                db.close();
            }});




        // 이미지뷰 불러오기
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }

        });

    }
    //권한에 대한 응답이 있을때 작동하는 함수
    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        /* 권한을 허용 했을 경우 */
        if(requestCode == 1)
        { int length = permissions.length;
        for (int i = 0; i < length; i++)
        {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
            {
                // 동의
                Log.d("activity_info","권한 허용 : " + permissions[i]); }
        } } }
        public void checkSelfPermission()
        { String temp = "";
        //파일 읽기 권한 확인
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            { temp += Manifest.permission.READ_EXTERNAL_STORAGE + " "; }
            //파일 쓰기 권한 확인
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            { temp += Manifest.permission.WRITE_EXTERNAL_STORAGE + " "; }
            if (TextUtils.isEmpty(temp) == false)
            {
                // 권한 요청
                ActivityCompat.requestPermissions(this, temp.trim().split(" "),1); }
            else {
                // 모두 허용 상태
                Toast.makeText(this, "권한을 모두 허용", Toast.LENGTH_SHORT).show(); } }

    // 이미지 출력
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    imageView.setImageBitmap(img);
                } catch (Exception e) {

                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this,"사진 선택 취소",Toast.LENGTH_LONG).show();
            }
        }
    }

}
