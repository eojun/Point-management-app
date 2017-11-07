package com.example.qhshe.oops_1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qhshe on 2017-08-01.
 */

// 회원등록 요청을 웹서버로 보냄

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://gguoops.cafe24.com/Register.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userSno, String userName, int userGold, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userSno", userSno);
        parameters.put("userName", userName);
        parameters.put("userGold", userGold + "");
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
