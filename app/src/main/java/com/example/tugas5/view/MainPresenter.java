package com.example.tugas5.view;

import android.os.AsyncTask;
import android.util.Log;

import com.example.tugas5.entity.AppDatabase;
import com.example.tugas5.entity.DataPinjaman;

import java.util.List;

public class MainPresenter implements MainContact.presenter {
    private MainContact.view view;

    public MainPresenter(MainContact.view view) {
        this.view = view;
    }

    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase appDatabase;
        private DataPinjaman dataPinjaman;

        public InsertData(AppDatabase appDatabase, DataPinjaman dataPinjaman) {
            this.appDatabase = appDatabase;
            this.dataPinjaman = dataPinjaman;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return appDatabase.dao().insertData(dataPinjaman);
        }

        protected void onPostExecute(Long along) {
            super.onPostExecute(along);
            view.successAdd();
        }
    }

    @Override
    public void insertData(String nama, String tanggal, String nohp, String alamat, int total, int waktu, AppDatabase database) {
        final DataPinjaman dataPinjaman = new DataPinjaman();
        dataPinjaman.setName(nama);
        dataPinjaman.setDate(tanggal);
        dataPinjaman.setPhone(nohp);
        dataPinjaman.setAddress(alamat);
        dataPinjaman.setTotal(total);
        dataPinjaman.setTime(waktu);
        new InsertData(database, dataPinjaman).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List<DataPinjaman> list;
        list = database.dao().getData();
        view.getData(list);
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase appDatabase;
        private DataPinjaman dataPinjaman;

        public EditData(AppDatabase appDatabase, DataPinjaman dataPinjaman) {
            this.appDatabase = appDatabase;
            this.dataPinjaman = dataPinjaman;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return appDatabase.dao().updateData(dataPinjaman);
        }

        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute : " + integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String nama, String tanggal, String nohp, String alamat, int total, int waktu, int id, AppDatabase database) {
        final DataPinjaman dataPinjaman = new DataPinjaman();
        dataPinjaman.setName(nama);
        dataPinjaman.setDate(tanggal);
        dataPinjaman.setPhone(nohp);
        dataPinjaman.setAddress(alamat);
        dataPinjaman.setTotal(total);
        dataPinjaman.setTime(waktu);
        dataPinjaman.setId(id);
        new EditData(database, dataPinjaman).execute();
    }

    class DeleteData extends AsyncTask<Void, Void, Long> {
        private AppDatabase appDatabase;
        private DataPinjaman dataPinjaman;

        public DeleteData(AppDatabase appDatabase, DataPinjaman dataPinjaman) {
            this.appDatabase = appDatabase;
            this.dataPinjaman = dataPinjaman;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            appDatabase.dao().deleteData(dataPinjaman);
            return null;
        }

        protected void onPostExecute(Long along) {
            super.onPostExecute(along);
            view.successDelete();
        }
    }

    @Override
    public void deleteData(DataPinjaman dataPinjaman, AppDatabase database) {
        new DeleteData(database, dataPinjaman).execute();
    }

}