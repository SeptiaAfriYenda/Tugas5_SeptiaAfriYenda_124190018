package com.example.tugas5.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas5.R;
import com.example.tugas5.entity.DataPinjaman;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder>{
    Context context; List<DataPinjaman> list;
    MainContact.view mView;
    public MainAdapter(Context context, List<DataPinjaman> list, MainContact.view mView) {
        this.context = context;
        this.list = list;
        this.mView = mView; }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kredit,parent,false);
        return new viewHolder(view); }
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    { final DataPinjaman item = list.get(position);
    holder.tvNama.setText(item.getName());
    holder.tvTtl.setText(item.getDate());
    holder.tvNohp.setText(item.getPhone());
    holder.tvAlamat.setText(item.getAddress());
    holder.tvJumlah.setText(item.getTotal());
    holder.tvWaktu.setText(item.getTime());
    holder.tvId.setText(item.getId());
    holder.cardView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) { mView.editData(item); } });
    holder.cardView.setOnLongClickListener(new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View view) { mView.deleteData(item); return true;
        }
    });
    }
    @Override
    public int getItemCount() { return list.size(); }
    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNama,tvAlamat,tvJumlah,tvId,tvTtl,tvNohp,tvWaktu;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.item_nama);
            tvTtl = itemView.findViewById(R.id.item_ttl);
            tvNohp = itemView.findViewById(R.id.item_nohp);
            tvAlamat = itemView.findViewById(R.id.item_alamat);
            tvJumlah = itemView.findViewById(R.id.item_jumlah);
            tvWaktu = itemView.findViewById(R.id.item_waktu);
            tvId = itemView.findViewById(R.id.item_id);
            cardView = itemView.findViewById(R.id.cv_item);
        }
    }
}
