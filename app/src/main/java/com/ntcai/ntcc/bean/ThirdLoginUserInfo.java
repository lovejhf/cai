package com.ntcai.ntcc.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 吴健 on 2017/8/22.
 */

public class ThirdLoginUserInfo implements Parcelable {
    private String userIcon;
    private String userName;
    private Gender userGender;
    private String userNote;
    private int gender;
    private String platformName;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public static enum Gender {BOY, GIRL}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userIcon);
        dest.writeString(this.userName);
        dest.writeInt(this.userGender == null ? -1 : this.userGender.ordinal());
        dest.writeString(this.userNote);
        dest.writeInt(this.gender);
        dest.writeString(this.platformName);
    }

    public ThirdLoginUserInfo() {
    }

    protected ThirdLoginUserInfo(Parcel in) {
        this.userIcon = in.readString();
        this.userName = in.readString();
        int tmpUserGender = in.readInt();
        this.userGender = tmpUserGender == -1 ? null : Gender.values()[tmpUserGender];
        this.userNote = in.readString();
        this.gender = in.readInt();
        this.platformName = in.readString();
    }

    public static final Creator<ThirdLoginUserInfo> CREATOR = new Creator<ThirdLoginUserInfo>() {
        @Override
        public ThirdLoginUserInfo createFromParcel(Parcel source) {
            return new ThirdLoginUserInfo(source);
        }

        @Override
        public ThirdLoginUserInfo[] newArray(int size) {
            return new ThirdLoginUserInfo[size];
        }
    };
}
