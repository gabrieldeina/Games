package com.deina.jogos.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.deina.jogos.R;
import com.deina.jogos.controller.GameDAO;
import com.deina.jogos.model.Game;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvNameDetail;
    TextView tvPublisherDetail;
    TextView tvGenreDetail;
    TextView tvYearDetail;
    Button btnDelete;
    Button btnEdit;
    GameDAO gameDAO;

    boolean deleted = false;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvNameDetail = findViewById(R.id.tvNameDetail);
        tvPublisherDetail = findViewById(R.id.tvPublisherDetail);
        tvGenreDetail = findViewById(R.id.tvGenreDetail);
        tvYearDetail = findViewById(R.id.tvYearDetail);
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);

        gameDAO = new GameDAO();

        Intent intentDetails = getIntent();
        position = intentDetails.getIntExtra("position", -1);

        if (position == -1) {
            finish();
        }

        btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Excluir Jogo")
                    .setMessage("Deseja excluir este jogo?")
                    .setPositiveButton("Sim!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gameDAO.remove(position);
                            deleted = true;
                            onResume();
                        }
                    })
                    .setNegativeButton("Não", null)
                    .show();
        });

        btnEdit.setOnClickListener(v -> {
            Intent editIntent = new Intent(this, CreateActivity.class);
            editIntent.putExtra("position", position);
            startActivity(editIntent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(deleted) {
            Toast.makeText(this, "Jogo Removido!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Game game = gameDAO.getGame(position);
            tvNameDetail.setText(game.getName());
            tvPublisherDetail.setText(game.getPublisher());
            tvGenreDetail.setText(game.getGenre());
            tvYearDetail.setText(game.getYear());
        }

    }
}