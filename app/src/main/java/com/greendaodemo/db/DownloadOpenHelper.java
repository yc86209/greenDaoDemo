package com.greendaodemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.greendaodemo.gen.DaoMaster;
import com.greendaodemo.gen.UserDao;
import com.socks.library.KLog;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Kenvin on 2017/11/2.
 */
public class DownloadOpenHelper extends DaoMaster.OpenHelper {

    public DownloadOpenHelper(Context context, String name) {
        this(context, name, null);
    }

    public DownloadOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 升级数据库
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        KLog.w("db version update from " + oldVersion + " to " + newVersion);
        MigrationHelper.getInstance().migrate(db, UserDao.class);
    }
}
