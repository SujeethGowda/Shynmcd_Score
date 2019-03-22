package com.example.shynmcd;

public class DataRepository {
    private static DataRepository sInstance;

    private final MasterRepository masterRepository;

    private DataRepository(final AppDatabase database){
        masterRepository = MasterRepository.getInstance(database);
    }

    public static DataRepository getInstance(final AppDatabase database){
        if (sInstance == null){
            synchronized (DataRepository.class){
                if (sInstance == null){
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public MasterRepository getMasterRepository(){return masterRepository;}
}
