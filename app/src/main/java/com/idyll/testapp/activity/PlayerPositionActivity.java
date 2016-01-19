package com.idyll.testapp.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.idyll.testapp.R;
import com.idyll.testapp.fragment.PlayerFragment;

/**
 * @author shibo
 * @packageName com.idyll.testapp.activity
 * @description
 * @date 16/1/18
 */
public class PlayerPositionActivity extends Activity {

    private Fragment playerFragment;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_position);
        initFragment();
    }

    private void initFragment() {
        if (playerFragment == null) {
            playerFragment = new PlayerFragment();
        }
        if (fm == null) {
            fm = getFragmentManager();
        }
        fm.beginTransaction().replace(R.id.fly_player_fragment, playerFragment).commit();
    }
}
