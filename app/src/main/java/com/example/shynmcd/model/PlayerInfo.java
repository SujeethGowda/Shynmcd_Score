package com.example.shynmcd.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PlayerInfoDetails")
public class PlayerInfo {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "UID", typeAffinity = ColumnInfo.TEXT)
    private String uid;

    @ColumnInfo(name = "NAME", typeAffinity = ColumnInfo.TEXT)
    private String name;

    @ColumnInfo(name = "TEAM", typeAffinity = ColumnInfo.TEXT)
    private String team;

    @ColumnInfo(name = "SIX", typeAffinity = ColumnInfo.INTEGER)
    private int six;

    @ColumnInfo(name = "FOUR", typeAffinity = ColumnInfo.INTEGER)
    private int four;

    @ColumnInfo(name = "WICKETS", typeAffinity = ColumnInfo.INTEGER)
    private int wickets;

    public void setSix(int six) {
        this.six = six;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getSix() {
        return six;
    }

    public int getFour() {
        return four;
    }

    public int getWickets() {
        return wickets;
    }
}
