package com.herdin.android.service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/6/3  6:51 下午
 * @desc:
 * @version: V-1.0.0
 **/
public class MyBook implements Parcelable {

    private int bookId;
    private String bookName;

    public MyBook() {
    }

    protected MyBook(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    public static final Creator<MyBook> CREATOR = new Creator<MyBook>() {
        @Override
        public MyBook createFromParcel(Parcel in) {
            return new MyBook(in);
        }

        @Override
        public MyBook[] newArray(int size) {
            return new MyBook[size];
        }
    };

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }

    public void readFromParcel(Parcel dest) {
        bookId = dest.readInt();
        bookName = dest.readString();
    }

}
