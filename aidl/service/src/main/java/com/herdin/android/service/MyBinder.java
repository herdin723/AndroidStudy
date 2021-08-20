package com.herdin.android.service;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/6/3  5:31 下午
 * @desc:
 * @version: V-1.0.0
 **/
public class MyBinder extends IMyAidlInterface.Stub{
    private static final String TAG = MyBinder.class.getSimpleName();
    List<MyBook> myBookList = new ArrayList<>();

    @Override
    public String getName() throws RemoteException {
        return "Hello AIDL";
    }

    @Override
    public List<MyBook> getBookList() throws RemoteException {
        List<MyBook> list = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            MyBook myBook = new MyBook();
            myBook.setBookId(index);
            myBook.setBookName("书"+index);
            list.add(myBook);
        }
        myBookList.addAll(list);
        return myBookList;
    }

    @Override
    public void addBook(MyBook book) throws RemoteException {
        myBookList.add(book);
    }

    @Override
    public MyBook addBookIn(MyBook book) throws RemoteException {
        Log.d(TAG, "addBookIn: "+book.getBookName());
        book.setBookId(1111);
        return book;
    }

    @Override
    public MyBook addBookOut(MyBook book) throws RemoteException {
        Log.d(TAG, "addBookOut: "+book.getBookName());
        book.setBookId(2222);
        book.setBookName("Out2");
        return book;
    }

    @Override
    public MyBook addBookInout(MyBook book) throws RemoteException {
        Log.d(TAG, "addBookInout: "+book.getBookName());
        book.setBookId(3333);
        return book;
    }
}
