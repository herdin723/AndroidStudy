// IMyAidlInterface.aidl
package com.herdin.android.service;

// Declare any non-default types here with import statements
import com.herdin.android.service.MyBook;

interface IMyAidlInterface {
//    /**
//     * Demonstrates some basic types that you can use as parameters
//     * and return values in AIDL.
//     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);

    String getName();

    List<MyBook> getBookList();

    //  void addBook(MyBook book);

    void addBook(inout MyBook book);

    //通过三种定位tag做对比试验，观察输出的结果
    MyBook addBookIn(in MyBook book);
    MyBook addBookOut(out MyBook book);
    MyBook addBookInout(inout MyBook book);
}