package com.example.qhshe.oops_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// admin이 로그인 할 경우 Mypage에 회원관리 버튼이 활성화되게 만듬
// 현재 가입한 인원들의 정보를 보여줌
// 추후 필요시 회원삭제버튼 추가

// 회원들의 정보를 웹서버 안에있는 User에서 가져옴

public class ManagermentActivity extends AppCompatActivity {

    private ListView listView;
    private UserListAdapter adapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerment);

        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.listView);
        userList = new ArrayList<User>();
        adapter = new UserListAdapter(getApplicationContext(), userList);
        listView.setAdapter(adapter);

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String userSno, userName, userGold;
            while(count < jsonArray.length())
            {
                JSONObject object = jsonArray.getJSONObject(count);
                userSno = object.getString("userSno");
                userName = object.getString("userName");
                userGold = object.getString("userGold");
                User user = new User(userSno, userName, userGold);
                userList.add(user);
                count++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
