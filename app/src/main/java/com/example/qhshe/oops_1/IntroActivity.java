package com.example.qhshe.oops_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// 인트로 이미지 구현
// 2초간 나타났다가 사라짐

public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this, LoginActivity.class));
        finish();


    }
}
