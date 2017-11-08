package com.example.wins.supermarket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    EditText user, password, repassword, email;
    Button register, back;
    SharedPreferences.Editor editor;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiset);
        setTitle("注册账号");

        user = (EditText) findViewById(R.id.loginAc);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        email = (EditText) findViewById(R.id.email);

        register = (Button) findViewById(R.id.register);
        back = (Button) findViewById(R.id.back);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User, Password, Repassword, Email;

                User = user.getText().toString();
                Password = password.getText().toString();
                Repassword = repassword.getText().toString();
                Email = email.getText().toString();

                editor = getSharedPreferences("user",MODE_PRIVATE).edit();

                if(User.equals("") || Password.equals("") || Repassword.equals("") ) {
                    Toast.makeText(getApplicationContext(), "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
                }
                else if(Password.equals(Repassword)) {

                        editor.putString("user", User);
                        editor.putString("password", Password);
                        editor.putString("email", Email);
                        editor.commit();

                        //提示注册成功
                         Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(registerActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                    else {
                        //提示框
                        Toast.makeText(getApplicationContext(), "注册失败，两次密码不一致", Toast.LENGTH_SHORT).show();
                    }
            }
        });
       /* back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registerActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });*/

    }
}
