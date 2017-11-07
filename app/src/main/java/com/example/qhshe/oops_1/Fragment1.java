package com.example.qhshe.oops_1;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/*
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);

        // 골드조회
        // DB와 연동하여 아이디를 대조해 사용자의 골드를 표시
        TextView goldText = v.findViewById(R.id.goldText);
        Intent intent = getActivity().getIntent();
        String userGold = intent.getStringExtra("userGold");
        goldText.setText(userGold);


        return v;
        //return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

}
