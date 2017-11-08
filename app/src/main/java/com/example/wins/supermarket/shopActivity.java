package com.example.wins.supermarket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.wins.supermarket.fragment.*;

import static com.example.wins.supermarket.fragment.FragmentOne.*;

public class shopActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {


    BottomNavigationBar mBottomNavigationBar;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;
    private FragmentFour mFragmentFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home, getString(R.string.tab_one)).setInactiveIconResource(R.drawable.home_fill).setActiveColorResource(R.color.colorBlack).setInActiveColorResource(R.color.coloGrey))
                .addItem(new BottomNavigationItem(R.drawable.fen, getString(R.string.tab_two)).setInactiveIconResource(R.drawable.fen_fill).setActiveColorResource(R.color.colorBlack).setInActiveColorResource(R.color.coloGrey))
                .addItem(new BottomNavigationItem(R.drawable.shop, getString(R.string.tab_three)).setInactiveIconResource(R.drawable.shop_fill).setActiveColorResource(R.color.colorBlack).setInActiveColorResource(R.color.coloGrey))
                .addItem(new BottomNavigationItem(R.drawable.people, getString(R.string.tab_four)).setInactiveIconResource(R.drawable.people_fill).setActiveColorResource(R.color.colorBlack).setInActiveColorResource(R.color.coloGrey))
                .setFirstSelectedPosition(0)
                .initialise();

         mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();


     //   mFragmentOne = newInstance("First Fragment");
        //2、调用对象的set方法，回传接口对象
        mFragmentOne.setOnButtonClick(new OnButtonClick() {
            //3、实现接口对象的方法，
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //切换到TwoFragment
                mFragmentTwo = FragmentTwo.newInstance("Second Fragment");
                transaction.replace(R.id.ll_content,mFragmentTwo).commit();//替换为TwoFragment

            }
        });
        //初始化用户状态
        appstateinit();

    }

    private void appstateinit() {
      //  SharedPreferences.Editor editor = getSharedPreferences("state",MODE_PRIVATE).edit();
      //  editor.putString("user","");
      //  editor.commit();
    }


    /**
     * set the default fragment
     */
    private void setDefaultFragment() {
        //要在activity 中管理 fragment 就要用到 FragmentTransaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //初始化的替换
        //执行newInstance 把"First Fragment" 传递过去
        mFragmentOne = newInstance("First Fragment");
        //用FragmentOne替换 到R.id.ll.content 并提交事务
        transaction.replace(R.id.ll_content, mFragmentOne).commit();
    }
    //底部 tab 选中监听函数
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mFragmentOne == null) {
                    mFragmentOne = newInstance("First Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentOne);
                break;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo = FragmentTwo.newInstance("Second Fragment");

                }
                transaction.replace(R.id.ll_content, mFragmentTwo);
                break;
            case 2:
                if (mFragmentThree == null) {
/*
                    shoparea myshoparea = new shoparea();
                    ShoppingCartBean myshopbean = new ShoppingCartBean();

                    myshopbean = myshoparea.getshopbean();

                    String name = myshopbean.getShoppingName();
                    double seal = myshopbean.getPrice();
                    String url = myshopbean.getImageUrl();
                    int count = myshopbean.getCount();*/




               //     mFragmentThree = FragmentThree.newShopbean(name,seal,url,count);
                    mFragmentThree = FragmentThree.newInstance("Third Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentThree);
                break;
            case 3:
                if (mFragmentFour == null) {
                    mFragmentFour = FragmentFour.newInstance("Forth Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentFour);
                break;
            default:
                if (mFragmentOne == null) {
                    mFragmentOne = newInstance("First Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentOne);
                break;
        }
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
