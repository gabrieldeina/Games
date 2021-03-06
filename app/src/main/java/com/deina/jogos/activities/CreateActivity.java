package com.deina.jogos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deina.jogos.R;
import com.deina.jogos.controller.GameDAO;
import com.deina.jogos.model.Game;

public class CreateActivity extends AppCompatActivity {

    EditText etName;
    EditText etPublisher;
    EditText etGenre;
    EditText etYear;
    Button btnAdd;

    boolean editMode = false;

    GameDAO gameDAO;
    Game g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etName = findViewById(R.id.etName);
        etPublisher = findViewById(R.id.etPublisher);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        btnAdd = findViewById(R.id.btnAdd);

        gameDAO = new GameDAO();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        if(position != -1) {
            Game g = gameDAO.getGame(position);
            etName.setText(g.getName());
            etPublisher.setText(g.getPublisher());
            etGenre.setText(g.getGenre());
            etYear.setText(String.valueOf(g.getYear()));

            editMode = true;
        }

        btnAdd.setOnClickListener(v -> {
            if(etName.getText().toString().isEmpty() ||
            etPublisher.getText().toString().isEmpty() ||
            etGenre.getText().toString().isEmpty() ||
            etYear.getText().toString().isEmpty()
            ) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                Game game = new Game(
                        etName.getText().toString(),
                        etPublisher.getText().toString(),
                        etGenre.getText().toString(),
                        Integer.parseInt(etYear.getText().toString())
                );

                if(!editMode) {
                    gameDAO.addGame(game);
                } else {
                    gameDAO.editGame(position, game);
                }


                Toast.makeText(this, "Jogo cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}