package com.itish.itsplit;

import android.os.Parcel;
import android.os.Parcelable;

public class user implements Parcelable {
    String u_name,u_payment;

    public user() {
    }

    public user(String u_name, String u_payment) {
        this.u_name = u_name;
        this.u_payment = u_payment;
    }

    protected user(Parcel in) {
        u_name = in.readString();
        u_payment = in.readString();
    }

    public static final Creator<user> CREATOR = new Creator<user>() {
        @Override
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        @Override
        public user[] newArray(int size) {
            return new user[size];
        }
    };

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_payment() {
        return u_payment;
    }

    public void setU_payment(String u_payment) {
        this.u_payment = u_payment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(u_name);
        parcel.writeString(u_payment);
    }
}

