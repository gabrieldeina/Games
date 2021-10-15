package com.deina.jogos.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deina.jogos.R;
import com.deina.jogos.activities.DetalhesActivity;
import com.deina.jogos.controller.GameDAO;
import com.deina.jogos.model.Game;

public class GameAdapter extends RecyclerView.Adapter {

    private Context context;
    private GameDAO gameDAO;

    public GameAdapter(Context context, GameDAO gameDAO) {
        this.context = context;
        this.gameDAO = gameDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewGame = LayoutInflater.from(context).inflate(R.layout.layout_game, parent, false);
        GameViewHolder gameViewHolder = new GameViewHolder(viewGame);

        return gameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GameViewHolder gameViewHolder = (GameViewHolder) holder;

        Game g = gameDAO.getGame(position);
        gameViewHolder.tvName.setText(g.getName());
        gameViewHolder.tvPublisher.setText(g.getPublisher());
        gameViewHolder.tvGenre.setText(g.getGenre());
        gameViewHolder.tvYear.setText(String.valueOf(g.getYear()));

        gameViewHolder.btnDetails.setOnClickListener(v -> {
            Intent detailsIntent = new Intent(context, DetalhesActivity.class);
            detailsIntent.putExtra("position", position);
            context.startActivity(detailsIntent);
        });
    }

    @Override
    public int getItemCount() {
        return gameDAO.getGamesList().size();
    }
}
