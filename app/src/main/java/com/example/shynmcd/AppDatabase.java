package com.example.shynmcd;

import android.content.Context;

import com.example.shynmcd.dao.PlayerInfoDao;
import com.example.shynmcd.model.PlayerInfo;

import java.util.concurrent.Executor;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = PlayerInfo.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;
    private static Executor executor;

    private static final String DATABASE_NAME = "playerInfo_db";
    private final MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    executor = executors.diskIO();
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updataDatebaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private void updataDatebaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private static AppDatabase buildDatabase(final Context context, final AppExecutors executors) {
        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .setQueryExecutor(executors.diskIO())
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(new Runnable() {
                            @Override
                            public void run() {
                                AppDatabase database = AppDatabase.getInstance(context, executors);
                                database.setDatabaseCreated();
                            }
                        });
                    }
                }).build();

    }

    public abstract PlayerInfoDao getPlayerInfDao();

    public LiveData<Boolean> getDatabaseCreated(){return mutableLiveData;}

    private void setDatabaseCreated() {
        mutableLiveData.postValue(true);
    }
}
