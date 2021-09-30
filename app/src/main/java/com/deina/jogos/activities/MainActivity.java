package com.deina.jogos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.deina.jogos.R;
import com.deina.jogos.adapter.GameAdapter;
import com.deina.jogos.controller.GameDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvGames;
    FloatingActionButton fabAdd;

    GameDAO gameDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGames = findViewById(R.id.rvGames);
        fabAdd = findViewById(R.id.fabAdd);

        gameDAO = new GameDAO();

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, CreateActivity.class));
        });

        RecyclerView.LayoutManager myLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        rvGames.setLayoutManager(myLayout);
    }

    @Override
    protected void onResume() {
        super.onResume();

        GameAdapter myAdapter = new GameAdapter(this, gameDAO);

        rvGames.setAdapter(myAdapter);
    }
}