package com.sponia.idyll.testapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.sponia.idyll.testapp.bean.PlayerBean;
import com.sponia.idyll.testapp.R;
import com.sponia.idyll.testapp.adapter.PlayerAdapter;
import com.sponia.idyll.testapp.view.PlayerTextItem;

import java.util.ArrayList;

/**
 * @author shibo
 * @packageName com.sponia.idyll.testapp.fragment
 * @description
 * @date 16/1/18
 */
public class PlayerFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnTouchListener{

    private GridView playerGV;
    private PlayerAdapter adapter;
    //队员
    private ArrayList<PlayerTextItem> mItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, null, false);
        playerGV = (GridView) view.findViewById(R.id.gv_player);

        for(int i = 0; i < 11; i++) {
            mItems.add(new PlayerTextItem(new PlayerBean(i +""), 0, true));
        }

        adapter = new PlayerAdapter(getActivity(), mItems);
        playerGV.setAdapter(adapter);
        playerGV.setOnItemClickListener(this);
        playerGV.setOnTouchListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
