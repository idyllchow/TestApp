package com.idyll.testapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import com.idyll.testapp.R;
import com.idyll.testapp.utils.LogUtil;
import com.idyll.testapp.view.IDrag;
import com.idyll.testapp.view.PlayerTextItem;

import java.util.ArrayList;

/**
 * Created by caolijie on 15/5/7.
 */
public abstract class DragGridBaseAdapter extends BaseAdapter implements IDrag {
    protected final ArrayList<PlayerTextItem> list;
    protected LayoutInflater mInflater;
    protected int mHidePosition = -1;

    protected int mItemWidth;
    protected int mItemHeight;

    protected int whiteColor;
    protected int redColor;
    protected int grayColor;
    protected int oldPosition = -1;
    protected int newPosition = -1;
    protected boolean isClick;

    public DragGridBaseAdapter(Context context, ArrayList<PlayerTextItem> list) {
        this.list = list;
        mInflater = LayoutInflater.from(context);
        whiteColor = Color.WHITE;
        redColor = context.getResources().getColor(R.color.R);
        grayColor = context.getResources().getColor(R.color.colorPrimary);
    }

    public void setItemWidthAndHeight(int width, int height) {
        mItemWidth = width;
        mItemHeight = height;
    }

    @Override
    public int getCount() {
        return null == list ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null == list ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (position < 0 || null == getItem(position)) ? -1 : position;
    }

    @Override
    public void reorderItems(int oldPosition, int newPosition) {
        PlayerTextItem oldItem = list.get(oldPosition);
        PlayerTextItem newItem = list.get(newPosition);
        list.set(oldPosition, newItem);
        list.set(newPosition, oldItem);
        notifyDataSetChanged();
    }

    @Override
    public void setHideItem(int hidePosition) {
        this.mHidePosition = hidePosition;
        notifyDataSetChanged();
    }

    @Override
    public void removeItem(int removePosition) {
        list.remove(removePosition);
        notifyDataSetChanged();
    }

    public void removeItemAndSetEmpty(int removePosition) {
        list.remove(removePosition);
        list.add(null);
        notifyDataSetChanged();
    }

    public void addMoreItems(ArrayList<PlayerTextItem> newItems) {
        this.list.addAll(newItems);
        notifyDataSetChanged();
    }

    public void removeAllItems() {
        this.list.clear();
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged(int oldPosition, int newPosition, boolean isClick) {
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
        this.isClick = isClick;
        notifyDataSetChanged();
    }

    public String getItemText(int position) {
        String text = "";
        try {
            text =  list.get(position).player.number;
        } catch (ArrayIndexOutOfBoundsException e) {
            LogUtil.defaultLog("ArrayIndexOutOfBoundsException");
        }
        return text;
    }
}
