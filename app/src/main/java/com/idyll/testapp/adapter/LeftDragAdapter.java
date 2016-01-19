package com.idyll.testapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idyll.testapp.R;
import com.idyll.testapp.view.PlayerTextItem;

import java.util.ArrayList;

/**
 * @packageName
 * @description 上场球员Adapter
 * @date 15/9/14
 * @auther shibo
 */
public class LeftDragAdapter extends DragGridBaseAdapter {

    public LeftDragAdapter(Context context, ArrayList<PlayerTextItem> list) {
        super(context, list);
    }

    /**
     * 由于复用convertView导致某些item消失了，所以这里不复用item，
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            convertView = mInflater.inflate(R.layout.item_player_num_grid, null, false);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.number_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PlayerTextItem player = list.get(position);
        if (null != player) {
            if ("-1".equals(player.player.number)) {
                holder.tv.setText("");
                holder.tv.setBackgroundResource(0);
            } else {
                holder.tv.setText(player.player.number);
                holder.tv.setBackgroundResource(R.drawable.bg_gray_ring_selector);
            }
            holder.tv.setTextColor(0 == position % 2 ? whiteColor : redColor);
            convertView.setVisibility(position == mHidePosition ? View.INVISIBLE : View.VISIBLE);
        } else {
            holder.tv.setText("");
            convertView.setVisibility(View.VISIBLE);
        }


        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    private static class ViewHolder {
        TextView tv;
    }
}