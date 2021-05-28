package com.example.tugas5.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "pinjaman_db")
public class DataPinjaman {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "address")
    private String address;
    @ColumnInfo(name = "total")
    private int total;
    @ColumnInfo(name = "time")
    private int time;

    public int getId()
        { return id; }
    public void setId(int id)
        { this.id = id; }
    public String getDate()
    { return date; }
    public void setDate(String date)
    { this.date = date; }
    public String getName()
        { return name; }
    public void setName(String name)
        { this.name = name; }
    public String getPhone()
    { return phone; }
    public void setPhone(String phone)
    { this.phone = phone; }
    public String getAddress()
        { return address; }
    public void setAddress(String address)
        { this.address = address; }
    public int getTotal()
        { return total; }
    public void setTotal(int total)
        { this.total = total; }
    public int getTime()
    { return time; }
    public void setTime(int time)
    { this.time = time; }}
