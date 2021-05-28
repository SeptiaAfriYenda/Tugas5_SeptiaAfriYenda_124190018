package com.example.tugas5.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugas5.R;
import com.example.tugas5.entity.AppDatabase;
import com.example.tugas5.entity.DataPinjaman;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.view {
    private AppDatabase appDatabase;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;
    private Button tombol;
    private RecyclerView recyclerView;
    private EditText etNama, etAlamat, etJumlah, etTtl, etNohp, etWaktu;
    private int id = 0;
    boolean edit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tombol = findViewById(R.id.btnsimpan);
        etNama = findViewById(R.id.etnama);
        etTtl = findViewById(R.id.etttl);
        etNohp = findViewById(R.id.etnohp);
        etAlamat = findViewById(R.id.etalamat);
        etJumlah = findViewById(R.id.etjumlah);
        etWaktu = findViewById(R.id.etwaktu);
        recyclerView = findViewById(R.id.rcmenu);
        appDatabase = AppDatabase.inidb(getApplicationContext());

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext()));
        mainPresenter = new MainPresenter(this);
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void successAdd() {
        Toast.makeText(this, "Input Data Berhasil", Toast.LENGTH_SHORT).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void resetForm() {
        etNama.setText("");
        etTtl.setText("");
        etNohp.setText("");
        etAlamat.setText("");
        etJumlah.setText("");
        etWaktu.setText("");
        tombol.setText("Simpan");
    }

    @Override
    public void getData(List<DataPinjaman> list) {
        mainAdapter = new MainAdapter(this, list, this);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void editData(DataPinjaman item) {
        etNama.setText(item.getName());
        etTtl.setText(item.getDate());
        etNohp.setText(item.getPhone());
        etAlamat.setText(item.getAddress());
        etJumlah.setText(item.getTotal());
        etWaktu.setText(item.getTime());
        id = item.getId();
        edit = true;
        tombol.setText("Edit Data");
    }

    @Override
    public void deleteData(DataPinjaman item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Menghapus Data")
                .setMessage("Apakah anda yakin untuk menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetForm();
                        mainPresenter.deleteData(item, appDatabase);
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        })
                .setIcon(android.R.drawable.ic_dialog_dialer).show();
    }

    @Override
    public void onClick(View view) {
        if(view==tombol){
            if(etNama.getText().toString().equals("")||
                    etTtl.getText().toString().equals("")||
                    etNohp.getText().toString().equals("")||
                    etAlamat.getText().toString().equals("")||
                    etJumlah.getText().toString().equals("")||
                    etWaktu.getText().toString().equals("")){
                Toast.makeText(this,"Masih ada data yang kosong, harap isi semua!", Toast.LENGTH_SHORT).show(); }
            else{ if(!edit){
                mainPresenter.insertData(etNama.getText().toString(),etTtl.getText().toString(),etNohp.getText().toString(),
                        etAlamat.getText().toString(), Integer.parseInt(etJumlah.getText().toString()),Integer.parseInt(etWaktu.getText().toString()),appDatabase); }
                    else{ mainPresenter.editData(etNama.getText().toString(),etTtl.getText().toString(),etNohp.getText().toString(),
                    etAlamat.getText().toString(), Integer.parseInt(etJumlah.getText().toString()),Integer.parseInt(etWaktu.getText().toString()),id,appDatabase);
                    edit = false; }
                    resetForm();
            }
        }
    }
}