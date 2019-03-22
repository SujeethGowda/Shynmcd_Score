package com.example.shynmcd;

import android.app.Application;

public class Shynmcd extends Application {

    private AppExecutors appExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        appExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, appExecutors);
    }

    public AppExecutors getAppExecutors() {
        return appExecutors;
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }

}
