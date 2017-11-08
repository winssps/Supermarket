package com.example.wins.supermarket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wins.supermarket.Constants;
import com.example.wins.supermarket.LoginActivity;
import com.example.wins.supermarket.R;
import com.example.wins.supermarket.ShoppingCartBean;
import com.example.wins.supermarket.shopActivity;
import com.example.wins.supermarket.shoparea;

import org.w3c.dom.Text;

/**
 * Created by Kevin on 2016/11/20.
 * Blog:http://blog.csdn.net/student9128
 * Describe：the first fragment
 */

public class FragmentOne extends Fragment {

    private OnButtonClick onButtonClick;//2、定义接口成员变量
    private ImageButton button;

    RelativeLayout re1,re2,re3,re4,re5,re6,re7,re8;
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,container,false);

     /*   button = (ImageButton) view.findViewById(R.id.bt1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(view.getContext(), LoginActivity.class);
              //  startActivity(intent);
            //    FragmentManager fm = getActivity().getSupportFragmentManager();
            //    FragmentTwo fragmentTwo = FragmentTwo.newInstance("First Fragment");
            //    fm.beginTransaction().replace(R.id.ll_content,fragmentTwo).commit();

                //4、如果接口成员变量不为空null，则调用接口变量的方法。

                if(onButtonClick != null){
                    onButtonClick.onClick(button);
                    Log.d("sdfsdf","sldjfsldjfsd");
                }
            }
        });
        */
        re1 = (RelativeLayout) view.findViewById(R.id.rea1);
        re2 = (RelativeLayout) view.findViewById(R.id.rea2);
        re3 = (RelativeLayout) view.findViewById(R.id.rea3);
        re4 = (RelativeLayout) view.findViewById(R.id.rea4);
        re5 = (RelativeLayout) view.findViewById(R.id.rea5);
        re6 = (RelativeLayout) view.findViewById(R.id.rea6);
        re7 = (RelativeLayout) view.findViewById(R.id.rea7);
        re8 = (RelativeLayout) view.findViewById(R.id.rea8);

        re1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),shoparea.class);
                startActivity(intent);
            }
        });
        re2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),shoparea.class);
                startActivity(intent);
            }
        });
        re3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),shoparea.class);
                startActivity(intent);
            }
        });
        re4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),shoparea.class);
                startActivity(intent);
            }
        });
        re5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),shoparea.class);
                startActivity(intent);
            }
        });
        re6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),shoparea.class);
                startActivity(intent);
            }
        });
        re7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),shoparea.class);
                startActivity(intent);
            }
        });
        re8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),shoparea.class);
                startActivity(intent);
            }
        });







        return view;
    }
    //定义接口变量的get方法
    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }
    //定义接口变量的set方法
    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }
    //1、定义接口
    public interface OnButtonClick{
        public void onClick(View view);
    }
    /*public ShoppingCartBean getFoods(ImageButton id, RelativeLayout id) {
        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView foodsname = (TextView) view.findViewById(R.id.spm1);
                String name = foodsname.getText().toString();
            }
        });
    }*/




    public static FragmentOne newInstance(String s){

        FragmentOne fragment = new FragmentOne();
        Bundle bundle = new Bundle();
        //"args" 作为索引值 传递 s
        bundle.putString(Constants.KEY_ARGS,s);
        //讲bundle 作为fragment的参数保存  返回当前 FragmentOne 对象
        fragment.setArguments(bundle);
        return fragment;
    }

}
