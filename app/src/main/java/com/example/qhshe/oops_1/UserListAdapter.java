package com.example.qhshe.oops_1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by qhshe on 2017-08-05.
 */

public class UserListAdapter extends BaseAdapter{

    private Context context;
    private List<User> userList;

    public UserListAdapter(Context context, List<User> userList){
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {

        return userList.size();
    }

    @Override
    public Object getItem(int i) {

        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.user, null);
        TextView userSno = v.findViewById(R.id.userSno);
        TextView userName = v.findViewById(R.id.userName);
        TextView userGold = v.findViewById(R.id.userGold);

        userSno.setText(userList.get(i).getUserSno());
        userName.setText(userList.get(i).getUserName());
        userGold.setText(userList.get(i).getUserGold());

        v.setTag(userList.get(i).getUserSno());
        return v;
    }
}
