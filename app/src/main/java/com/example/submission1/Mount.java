package com.example.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Mount implements Parcelable {
    private String name;
    private String from;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.from);
        dest.writeString(this.photo);
    }

    public Mount() {
    }

    protected Mount(Parcel in) {
        this.name = in.readString();
        this.from = in.readString();
        this.photo = in.readString();
    }

    public static final Creator<Mount> CREATOR = new Creator<Mount>() {
        @Override
        public Mount createFromParcel(Parcel source) {
            return new Mount(source);
        }

        @Override
        public Mount[] newArray(int size) {
            return new Mount[size];
        }
    };
}
