package com.sponia.idyll.testapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sponia.idyll.testapp.R;
import com.sponia.idyll.testapp.view.LoadingAnimatorView;

public class MainActivityBinding extends Activity implements View.OnClickListener {

    private LoadingAnimatorView view;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        User user = new User("Test", "User");
//        binding.setUser(user);

//            view = new LoadingAnimatorView(this);
//            setContentView(view);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tv1:
                Intent intent = new Intent(this, CanvasDemoActivity.class);
                startActivity(intent);
                break;
            case R.id.tv2:
                startActivity(new Intent(this, PlayerPositionActivity.class));
                break;
            default:
                break;
        }
    }
}
