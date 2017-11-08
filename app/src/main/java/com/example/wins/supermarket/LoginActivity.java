package com.example.wins.supermarket;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.wins.supermarket.fragment.*;


public class LoginActivity extends AppCompatActivity{


    private boolean result = true;

    EditText user, password;
    Button login, reg;
    SharedPreferences sp, read;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("全部分类");
        setContentView(R.layout.login);

        //    注册
        reg = (Button) findViewById(R.id.reg);
        login = (Button) findViewById(R.id.login);
        user = (EditText) findViewById(R.id.loginAc);
        password = (EditText) findViewById(R.id.password);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,registerActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User, Password, Email;
                //从里边取出账号密码
                 sp = getSharedPreferences("user",MODE_PRIVATE);
                User =  sp.getString("user","");
                Password = sp.getString("password","");
                Email = sp.getString("email","");

                //对比输入的账号密码
                if(User.equals(user.getText().toString()) && Password.equals(password.getText().toString()) ) {
                    //登录成功！ 刷新个人页面
                    Log.d("user", User);
                    Log.d("password", Password);
                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();

                    //存储当前用户名
                    editor = getSharedPreferences("state",MODE_PRIVATE).edit();
                    editor.putString("user",User);
                    editor.commit();

                    read = getSharedPreferences("state",MODE_PRIVATE);
                    Log.d("存进去的状态state:", read.getString("user",""));

                    Intent intent = new Intent(LoginActivity.this,shopActivity.class);
                    startActivity(intent);
                }
                else {
                    //提示框
                    Toast.makeText(getApplicationContext(), "您的用户名或密码不正确！", Toast.LENGTH_SHORT).show();
                }

            }
        });

     /*   RadioGroup type = (RadioGroup) findViewById(R.id.shopkeepertype);


        type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //被选中的RadioButton
                RadioButton info = (RadioButton) findViewById(i);

                RadioButton mai1 = (RadioButton) findViewById(R.id.mai1);
                RadioButton mai2 = (RadioButton) findViewById(R.id.mai2);
                if(result) {
                    result = false;
                    mai1.setChecked(false);
                }
                else {
                    result = true;
                    mai2.setChecked(false);
                }
            }
        });*/


    }

}
