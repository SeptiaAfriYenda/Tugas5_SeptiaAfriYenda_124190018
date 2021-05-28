package com.example.tugas5.entity;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface DataPinjamanDAO {
    @Insert
    Long insertData(DataPinjaman dataPinjaman);
    @Query("Select * from pinjaman_db")
    List<DataPinjaman> getData();
    @Update
    int updateData(DataPinjaman item);
    @Delete
    void deleteData(DataPinjaman item); }
