package com.example.shynmcd.Model;

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

    @ColumnInfo(name = "SIX", typeAffinity = ColumnInfo.TEXT)
    private String six;

    @ColumnInfo(name = "FOUR", typeAffinity = ColumnInfo.TEXT)
    private String four;

    @ColumnInfo(name = "WICKETS", typeAffinity = ColumnInfo.TEXT)
    private String wickets;

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

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getWickets() {
        return wickets;
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }
}
