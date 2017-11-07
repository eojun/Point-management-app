package com.example.qhshe.oops_1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
/*****************************************************************************
// OOPS v1 - 금강대학교 골드조회 APP

// 만든이 - 김민섭, 강경림, 황어준, 박은빛, 이소영

// 금강대학교 골드 조회를 위한 어플리케이션
// 웹서버와 연동되어 사용자의 골드조회가 가능하게 함
// BottomNavigation과 Fragment의 대한 이해가 중요

// 파싱에 대한 이해도 부족
// 데이터 조회를 위한 sql 심화학습이 필요
// 명명법과 코드간결화가 필요

// 도움을 주신 금강대학교 조성환교수님, 김성식교수님에게 감사를 표시합니다.
*****************************************************************************/


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                // 골드조회
                case R.id.navigation_goldView:
                    getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setCustomView(R.layout.abs_layout);
                    Fragment1 fragment1 = new Fragment1();
                    android.app.FragmentManager manager1 = getFragmentManager();
                    manager1.beginTransaction().replace(R.id.content, fragment1).commit();
                    return true;

                // 골드표
                case R.id.navigation_goldTable:
                    getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setCustomView(R.layout.abs_goldtable_layout);
                    //getSupportActionBar().setTitle("골드표");
                    Fragment3 fragmnet3 = new Fragment3();
                    android.app.FragmentManager manager3 = getFragmentManager();
                    manager3.beginTransaction().replace(R.id.content, fragmnet3).commit();
                    return true;

                // 마이페이지
                case R.id.navigation_MyPage:
                    getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setCustomView(R.layout.abs_mypage_layout);
                    Fragment4 fragment4 = new Fragment4();
                    android.app.FragmentManager manager4 = getFragmentManager();
                    manager4.beginTransaction().replace(R.id.content, fragment4).commit();
                    return true;
            }

            return false;

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BottomNavigation 사용
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // 로그인 이후 화면에 바로 골드조회창이 보이도록 설정
        Fragment1 fragment1 = new Fragment1();
        android.app.FragmentManager manager1 = getFragmentManager();
        manager1.beginTransaction().replace(R.id.content, fragment1).commit();

    }

}