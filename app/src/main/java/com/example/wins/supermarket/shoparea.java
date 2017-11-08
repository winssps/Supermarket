package com.example.wins.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wins.supermarket.fragment.FragmentThree;

import java.util.*;


/**
 * Created by Simpler on 17/11/5.
 */

public class shoparea extends AppCompatActivity {

    ImageView by1,by2,by3,by4,by5,by6;
    ShoppingCartBean myshopbean;
    ImageView im;
    TextView name, seal;
    static int num = 10;
    private FragmentThree mFragmentThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("全部分类");
        setContentView(R.layout.shoparea);

        by1 = (ImageView) findViewById(R.id.buy1);
        by2 = (ImageView) findViewById(R.id.buy2);
        by3 = (ImageView) findViewById(R.id.buy3);
        by4 = (ImageView) findViewById(R.id.buy4);
        by5 = (ImageView) findViewById(R.id.buy5);
        by6 = (ImageView) findViewById(R.id.buy6);


        by1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 im = (ImageView) findViewById(R.id.addimg1);
                 name = (TextView) findViewById(R.id.spm1);
                 seal = (TextView) findViewById(R.id.seal1);
                putshopbean(im, name, seal);
                Toast.makeText(getApplicationContext(), "添加到购物车成功", Toast.LENGTH_SHORT).show();

            }
        });
        by2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 im = (ImageView) findViewById(R.id.addimg2);
                 name = (TextView) findViewById(R.id.spm2);
                 seal = (TextView) findViewById(R.id.seal2);
            //    myshopbean = putshopbean(im, name, seal);
                putshopbean(im, name, seal);
                Toast.makeText(getApplicationContext(), "添加到购物车成功", Toast.LENGTH_SHORT).show();

            }
        });
        by3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 im = (ImageView) findViewById(R.id.addimg3);
                 name = (TextView) findViewById(R.id.spm3);
                 seal = (TextView) findViewById(R.id.seal3);
              //  myshopbean = putshopbean(im, name, seal);
                putshopbean(im, name, seal);
                Toast.makeText(getApplicationContext(), "添加到购物车成功", Toast.LENGTH_SHORT).show();

            }
        });
        by4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView im = (ImageView) findViewById(R.id.addimg4);
                TextView name = (TextView) findViewById(R.id.spm4);
                TextView seal = (TextView) findViewById(R.id.seal4);
            //    myshopbean = putshopbean(im, name, seal);
                putshopbean(im, name, seal);
                Toast.makeText(getApplicationContext(), "添加到购物车成功", Toast.LENGTH_SHORT).show();

            }
        });
        by5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 im = (ImageView) findViewById(R.id.addimg5);
                 name = (TextView) findViewById(R.id.spm5);
                 seal = (TextView) findViewById(R.id.seal5);
           //     myshopbean = putshopbean(im, name, seal);
                putshopbean(im, name, seal);
                Toast.makeText(getApplicationContext(), "添加到购物车成功", Toast.LENGTH_SHORT).show();

            }
        });
        by6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 im = (ImageView) findViewById(R.id.addimg6);
                 name = (TextView) findViewById(R.id.spm6);
                 seal = (TextView) findViewById(R.id.seal6);
             //   myshopbean = putshopbean(im, name, seal);
                putshopbean(im, name, seal);
                Toast.makeText(getApplicationContext(), "添加到购物车成功", Toast.LENGTH_SHORT).show();


            }
        });



    }

    public ShoppingCartBean getshopbean() {
        return  myshopbean;
    }

    public void putshopbean(ImageView im, TextView name, TextView seal) {
        ShoppingCartBean shoppingCartBean = new ShoppingCartBean();  //商品类  对象


        String spname = name.getText().toString();
        String myseal = seal.getText().toString();
        myseal = myseal.substring(2,3);
        int spseal = Integer.parseInt(myseal);
        String shopurl = "https://img.alicdn.com/bao/uploaded/i2/TB1YfERKVXXXXanaFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg";



        mFragmentThree = FragmentThree.newShopbean(spname,spseal,shopurl,1);


        myshopbean.setShoppingName(spname);
        myshopbean.setImageUrl(shopurl);
        myshopbean.setPrice(spseal);


     //   return shoppingCartBean;
    }

}
