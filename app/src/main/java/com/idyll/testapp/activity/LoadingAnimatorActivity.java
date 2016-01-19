package com.idyll.testapp.activity;

/**
 * @author shibo
 * @packageName com.idyll.testapp
 * @description
 * @date 15/12/22
 */
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.idyll.testapp.view.LoadingAnimatorView;

@SuppressLint("NewApi")
public class LoadingAnimatorActivity extends Activity{
    private LoadingAnimatorView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new LoadingAnimatorView(this);
        setContentView(view);
    }
    @Override
    public void onBackPressed() {
        view.flag = false;//结束绘制线程
        super.onBackPressed();
    }
}
