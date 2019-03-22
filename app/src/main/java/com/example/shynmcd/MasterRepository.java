package com.example.shynmcd;

import com.example.shynmcd.Dao.PlayerInfoDao;
import com.example.shynmcd.Model.PlayerInfo;

public class MasterRepository {
    private static MasterRepository sInstance;

    private final AppDatabase database;
    private  final PlayerInfoDao playerInfoDao;

    public MasterRepository(AppDatabase database){
        this.database = database;
        this.playerInfoDao = database.getPlayerInfDao();
    }

    public static MasterRepository getInstance(final AppDatabase database){
        if (sInstance == null){
            synchronized (DataRepository.class){
                if (sInstance == null){
                    sInstance = new MasterRepository(database);
                }
            }
        }
        return sInstance;
    }

    public void addPlayer (final PlayerInfo playerInfo){
        database.getQueryExecutor().execute(new Runnable() {
            @Override
            public void run() {
                if (playerInfo.getId() == 0){
                    long id = playerInfoDao.insert(playerInfo);
                }else{
                    int update = playerInfoDao.update(playerInfo);
                }
            }
        });
    }
}
