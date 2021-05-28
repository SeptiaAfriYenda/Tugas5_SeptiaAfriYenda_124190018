package com.example.tugas5.view;

import android.view.View;

import com.example.tugas5.entity.AppDatabase;
import com.example.tugas5.entity.DataPinjaman;

import java.util.List;
public interface MainContact {
    //untuk kodingan activity
    interface view extends View.OnClickListener{
    void successAdd();
    void successDelete();
    void resetForm();
    void getData(List<DataPinjaman> list);
    void editData(DataPinjaman item);
    void deleteData(DataPinjaman item); }
    //kodingan untuk database

    interface presenter{
    void insertData(String nama, String tanggal, String nohp, String alamat, int total, int waktu, AppDatabase database);
    void readData(AppDatabase database);
    void editData(String nama, String tanggal, String nohp, String alamat, int total, int waktu, int id, AppDatabase database);
    void deleteData(DataPinjaman dataPinjaman, AppDatabase database); }
}

