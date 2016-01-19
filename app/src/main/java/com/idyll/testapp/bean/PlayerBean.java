package com.idyll.testapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author shibo
 * @packageName com.idyll.testapp
 * @description
 * @date 16/1/18
 */
public class PlayerBean implements Parcelable {

    public String name;
    public String id;
    public String number;

    public PlayerBean(String number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.id);
        dest.writeString(this.number);
    }

    public PlayerBean() {
    }

    protected PlayerBean(Parcel in) {
        this.name = in.readString();
        this.id = in.readString();
        this.number = in.readString();
    }

    public static final Parcelable.Creator<PlayerBean> CREATOR = new Parcelable.Creator<PlayerBean>() {
        public PlayerBean createFromParcel(Parcel source) {
            return new PlayerBean(source);
        }

        public PlayerBean[] newArray(int size) {
            return new PlayerBean[size];
        }
    };
}
