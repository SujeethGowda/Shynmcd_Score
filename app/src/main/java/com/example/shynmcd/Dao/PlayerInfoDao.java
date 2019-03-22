package com.example.shynmcd.Dao;

import com.example.shynmcd.Model.PlayerInfo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PlayerInfoDao {
    @Query("select * from PlayerInfoDetails;")
    LiveData<List<PlayerInfo>> getAll();

    @Insert
    long insert(PlayerInfo playerInfo);

    @Update
    int update(PlayerInfo playerInfo);

    @Query("DELETE FROM PlayerInfoDetails")
    void deleteAllPlayers();

    @Delete
    void delete(PlayerInfo playerInfo);

    @Query("select * from PlayerInfoDetails;")
    List<PlayerInfo> getOutlets();

}
