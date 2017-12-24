package com.greendaodemo.util;

import android.app.Application;

import com.greendaodemo.BuildConfig;
import com.greendaodemo.db.DBManager;

/**
 * Creator：YOOOOO on 2017/12/25 01:01
 * Mail：youchin_li@newsoft.com.tw
 **/


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DBManager.init(this);
    }
}
