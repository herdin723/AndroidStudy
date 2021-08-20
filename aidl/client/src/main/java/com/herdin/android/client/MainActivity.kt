package com.herdin.android.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.content.ServiceConnection
import android.content.ComponentName

import android.content.Intent

import com.herdin.android.service.IMyAidlInterface

import android.os.IBinder
import android.os.RemoteException
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.herdin.android.service.MyBook


class MainActivity : AppCompatActivity() {

    private val ACTION = "android.intent.action.MyService"

    private var connection: ServiceConnection? = null
    private var myAidlInterface: IMyAidlInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                myAidlInterface = IMyAidlInterface.Stub.asInterface(service)
            }

            override fun onServiceDisconnected(name: ComponentName) {
                myAidlInterface = null
            }
        }
        val intent = Intent(ACTION)
        val cn = ComponentName("com.herdin.android.service", "com.herdin.android.service.MyService")
        intent.component = cn
        bindService(intent, connection!!, BIND_AUTO_CREATE)
    }

    fun onClick(view: View?) {
        try {
            val name: String = myAidlInterface!!.getName()
            val book = MyBook()
            book.setBookId(111)
            book.setBookName("书111")
            myAidlInterface!!.addBook(book)
            val list: List<MyBook> = myAidlInterface!!.getBookList()
            Toast.makeText(this, name + "----" + list.size, Toast.LENGTH_SHORT).show()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun onClickIn(view: View) {
        val book = MyBook()
        book.setBookId(222)
        book.setBookName("In")
        try {
            val myBook: MyBook = myAidlInterface!!.addBookIn(book)
            (view as Button).setText(myBook.getBookId().toString() + "--" + myBook.getBookName())
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun onClickInOut(view: View) {
        val book = MyBook()
        book.setBookId(444)
        book.setBookName("InOut")
        try {
            val myBook: MyBook = myAidlInterface!!.addBookInout(book)
            (view as Button).setText(myBook.getBookId().toString() + "--" + myBook.getBookName())
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    fun onClickOut(view: View) {
        val book = MyBook()
        book.setBookId(333)
        book.setBookName("Out")
        try {
            val myBook: MyBook = myAidlInterface!!.addBookOut(book)
            (view as Button).setText(myBook.getBookId().toString() + "--" + myBook.getBookName())
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }
}