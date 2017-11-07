package com.example.qhshe.oops_1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qhshe on 2017-08-01.
 */

// LoginrRequest
// 로그인 요청을 웹서버로 보냄

public class LoginRequest extends StringRequest {

    final static private String URL = "http://gguoops.cafe24.com/Login.php";
    private Map<String, String> parameters;

    public LoginRequest(String userSno, String userName, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userSno", userSno);
        parameters.put("userName", userName);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
