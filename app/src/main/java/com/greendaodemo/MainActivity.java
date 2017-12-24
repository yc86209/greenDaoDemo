package com.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.greendaodemo.db.DBManager;
import com.greendaodemo.entity.Book;
import com.greendaodemo.entity.User;
import com.greendaodemo.gen.BookDao;
import com.greendaodemo.gen.DaoMaster;
import com.greendaodemo.gen.DaoSession;
import com.greendaodemo.gen.UserDao;
import com.socks.library.KLog;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("", "onCreate: ");

        DaoSession daoSession = DBManager.getInstance().getDaoSession();

        UserDao userDao = daoSession.getUserDao();
        List<User> userDaoList = userDao.queryBuilder().list();
        KLog.e("____________________init___________________");
        if (userDaoList.size() == 0) {
            User user = new User(null, "1", 20);
            daoSession.insert(user);
            KLog.e(user.toString());
        } else {
            for (int i = 0; i < 3; i++) {
                Book book = new Book(null,8L,String.valueOf(i));
                daoSession.getBookDao().insert(book);
//                userDaoList.get(0).getBooks().add(book);
            }
        }

        KLog.e("____________________User_Book___________________");
        for (User user : userDaoList) {
            KLog.e(user.toString());
            for (Book book : user.getBooks()) {
                KLog.e(book.toString());
            }
        }

        KLog.e("____________________Book___________________");
        BookDao bookDao = daoSession.getBookDao();
        List<Book> books = bookDao.queryBuilder().list();
        for (Book book : books) {
            KLog.e("___________" + book.toString());
        }


    }
}
