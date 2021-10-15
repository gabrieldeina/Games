package com.deina.jogos.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deina.jogos.R;

public class GameViewHolder extends RecyclerView.ViewHolder {

    TextView tvName;
    TextView tvPublisher;
    TextView tvGenre;
    TextView tvYear;
    Button btnDetails;

    public GameViewHolder(@NonNull View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tvName);
        tvPublisher = itemView.findViewById(R.id.tvPublisher);
        tvGenre = itemView.findViewById(R.id.tvGenre);
        tvYear = itemView.findViewById(R.id.tvYear);
        btnDetails = itemView.findViewById(R.id.btnDetails);
    }
}
