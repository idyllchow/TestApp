package com.idyll.testapp.view;

import android.os.Parcel;
import android.os.Parcelable;

import com.idyll.testapp.bean.PlayerBean;

/**
 * @author shibo
 * @packageName com.soccerstats.bean
 * @description 球员号码文本项
 * @date 15/9/25
 */
public class PlayerTextItem implements Parcelable {
    public PlayerBean player;
    public int textColor;
    public boolean selected = false;

    public PlayerTextItem(PlayerBean player, int textColor, boolean selected) {
        this.player = player;
        this.textColor = textColor;
        this.selected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.player, 0);
        dest.writeInt(this.textColor);
        dest.writeByte(selected ? (byte) 1 : (byte) 0);
    }

    private PlayerTextItem(Parcel in) {
        this.player = in.readParcelable(PlayerBean.class.getClassLoader());
        this.textColor = in.readInt();
        this.selected = in.readByte() != 0;
    }

    public static final Parcelable.Creator<PlayerTextItem> CREATOR = new Parcelable.Creator<PlayerTextItem>() {
        public PlayerTextItem createFromParcel(Parcel source) {
            return new PlayerTextItem(source);
        }

        public PlayerTextItem[] newArray(int size) {
            return new PlayerTextItem[size];
        }
    };
}
