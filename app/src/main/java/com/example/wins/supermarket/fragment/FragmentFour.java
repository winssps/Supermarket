package com.example.wins.supermarket.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wins.supermarket.Constants;
import com.example.wins.supermarket.LoginActivity;
import com.example.wins.supermarket.R;
import com.example.wins.supermarket.registerActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Kevin on 2016/11/20.
 * Blog:http://blog.csdn.net/student9128
 * Describe：the forth fragment
 */

public class FragmentFour extends Fragment {

    ImageView userlogo;

    String user;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal,container,false);

        userlogo = (ImageView) view.findViewById(R.id.myselficon);


        userlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getState();
            }
        });

        return view;
    }
    public void getState() {
        SharedPreferences read = this.getActivity().getSharedPreferences("state", Context.MODE_PRIVATE);
        Log.d("state:", read.getString("user",""));
        if(read.getString("user","").equals("")) {
            Intent intent = new Intent(getActivity(),LoginActivity.class);
            startActivity(intent);
        }
    }

    public static FragmentFour newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentFour fragment = new FragmentFour();
        fragment.setArguments(bundle);
        return fragment;
    }

}
