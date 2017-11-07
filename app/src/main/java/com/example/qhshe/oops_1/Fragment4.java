package com.example.qhshe.oops_1;


import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {

    public Fragment4() {
        // Required empty public constructor
    }

    // MyPage 부분
    // 이름, 학번 표시
    // 로그아웃버튼과 admin일 경우 회원관리 버튼 활성화

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment4, container, false);

        Button managermentButton = v.findViewById(R.id.managermentButton);
        TextView myManager = v.findViewById(R.id.myManager);
        TextView myLogout = v.findViewById(R.id.myLogout);

        TextView myName = v.findViewById(R.id.myName);
        TextView mySno = v.findViewById(R.id.mySno);

        Intent intent = getActivity().getIntent();
        String userName = intent.getStringExtra("userName");
        String userSno = intent.getStringExtra("userSno");

        myName.setText(userName);
        mySno.setText(userSno);

        if(!userSno.equals("admin")){
            myManager.setVisibility(View.GONE);
        }

        myManager.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new BackgroundTask().execute();
            }
        });

        myLogout.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               Text_logout();
           }
        });

        return v;
        //return inflater.inflate(R.layout.fragment_fragment4, container, false);
    }

    public void Text_logout(){
        new AlertDialog.Builder(getActivity())
                .setTitle("로그아웃 안내 창").setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();

    }

    class BackgroundTask extends AsyncTask<Void, Void, String>{
        String target;

        @Override
        protected void onPreExecute() {
            target = "http://gguoops.cafe24.com/List.php";
        }

        @Override
        protected String doInBackground(Void... voids){
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate(values);
        }

        @Override
        public void onPostExecute(String result){
            Intent intent = new Intent(getActivity(), ManagermentActivity.class);
            intent.putExtra("userList", result);
            getActivity().startActivity(intent);
        }
    }

}
