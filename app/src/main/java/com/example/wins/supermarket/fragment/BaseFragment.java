package com.example.wins.supermarket.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wins.supermarket.Constants;
import com.example.wins.supermarket.R;


/**
 * Created by Kevin on 2016/11/20.
 * Blog:http://blog.csdn.net/student9128
 * Describe：the BaseFragment
 */

public class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);
        TextView mFragmentText = (TextView) view.findViewById(R.id.text1);

        Bundle bundle = getArguments();
        String args = bundle.getString(Constants.KEY_ARGS);
        mFragmentText.setText(args);
        return view;

    }
}
