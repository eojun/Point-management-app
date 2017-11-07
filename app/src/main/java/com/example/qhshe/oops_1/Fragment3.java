package com.example.qhshe.oops_1;


import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {


    public Fragment3() {
        // Required empty public constructor
    }

    // textview 선언
    private TextView goldTable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);

        // 골드표를 불러오기 위한 AsyncTask 준비
        goldTable = v.findViewById(R.id.goldTable);
        GetGoldTable task = new GetGoldTable();
        task.execute();

        return v;
        //return inflater.inflate(R.layout.fragment_fragment3, container, false);
    }

    // 골드표 보여주기
    // 골드표가 따로 존재하지 않아 학교 장학금조건으로 대체
    // 안드로이드의 표제작에 대한 심화학습 필요
    // 필요시 사진으로 대체
    private class GetGoldTable extends AsyncTask<Void, Void, Map<String,String>> {

        @Override
        protected Map<String, String> doInBackground(Void... params) {
            Map<String,String> result = new HashMap<>();
            try {
                Document document = Jsoup.connect("http://www.ggu.ac.kr/kor/graduate/scholarship.php").get();
                Elements elements = document.select(".contents");
                result.put("goldTable", elements.text());

            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Map<String, String> map) {

            goldTable.setText(map.get("goldTable"));

        }

    }

}
