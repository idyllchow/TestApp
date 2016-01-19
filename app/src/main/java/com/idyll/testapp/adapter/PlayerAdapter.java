package com.idyll.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.idyll.testapp.R;
import com.idyll.testapp.view.PlayerTextItem;

import java.util.ArrayList;


/**
 * @author shibo
 * @packageName com.soccerstats.adapter
 * @description 球员Adapter
 * @date 15/9/25
 */
public class PlayerAdapter extends BaseAdapter {
    private final ArrayList<PlayerTextItem> list;
    private final LayoutInflater mInflater;

    private int mItemWidth;
    private int mItemHeight;
    //比赛是否进行
    private boolean isPlaying;
    //是否为撤销动作
    private boolean isUndo;
    //上下文
    private Context mContext;

    public PlayerAdapter(Context context, ArrayList<PlayerTextItem> list) {
        this.list = list;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);

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
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlayerViewHolder holder;
        if (null == convertView) {
            convertView = mInflater.inflate(R.layout.item_player_num_grid, null, false);
            holder = new PlayerViewHolder();
            holder.numberTv = (TextView) convertView.findViewById(R.id.number_tv);
            convertView.setTag(holder);
        } else {
            holder = (PlayerViewHolder) convertView.getTag();
        }
        PlayerTextItem item = list.get(position);
        if (null != item && null != item.player) {

            holder.numberTv.setText(item.player.number);
//            int redColor = mContext.getResources().getColor(R.color.R);
//            int color = (0 == (position / 3 + position % 3) % 2) ? Color.WHITE : redColor;
//            if (isPlaying) {
//                if (isUndo) {
//                    holder.numberTv.setSelected(item.selected);
//                } else {
//                    holder.numberTv.setSelected(item.selected);
//                }
//                holder.numberTv.setTextColor(color);
//                holder.numberTv.setBackgroundResource(R.drawable.bg_gray_ring_selector);
//            } else {
//                //恢复比赛时不点亮之前选中的球员
//                item.selected = false;
//                holder.numberTv.setTextColor(Color.GRAY);
//                holder.numberTv.setBackgroundResource(0);
//            }
            holder.numberTv.setBackgroundResource(R.drawable.bg_gray_ring_selector);
        } else {
            holder.numberTv.setText("");
            holder.numberTv.setBackgroundResource(0);
        }


        PlayerTextItem playerTextItem = list.get(position);

        holder.numberTv.setOnClickListener(mClickListener);

        return convertView;
    }

    /**
     * 通知适配器更改
     *
     * @param isPlaying 比赛是否进行
     * @param isUndo    是否为撤销动作
     */
    public void notifyDataSetChanged(boolean isPlaying, boolean isUndo) {
        this.isPlaying = isPlaying;
        this.isUndo = isUndo;
        notifyDataSetChanged();
    }

    static class PlayerViewHolder {
        TextView numberTv;
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.item_image:
                    if (mDragClickListener != null) {
                        mDragClickListener.onIcon((Integer) v.getTag());
                    } else {
                        Toast.makeText(mContext, "onclick, item_image", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.ib_delete:
                    if (mDragClickListener != null) {
                        mDragClickListener.onDelete((Integer) v.getTag());
                    } else {
                        Toast.makeText(mContext, "onclick, ib_delete", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
        }
    };

    private OnDragClickListener mDragClickListener;
    public interface OnDragClickListener {
        void onIcon(int position);
        void onDelete(int position);
    }
    public void setOnDragClickListener(OnDragClickListener l) {
        mDragClickListener = l;
    }

    //-----------------------------------
    private boolean isEdit = false;
    public boolean isEdit() {
        return isEdit;
    }
    public void setEdit(boolean edit) {
        if (isEdit != edit) {
            isEdit = edit;
            notifyDataSetChanged();
        }
    }
}
