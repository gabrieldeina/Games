package com.deina.jogos.controller;

import com.deina.jogos.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    private static List<Game> gamesList = new ArrayList<>();

    public void addGame(Game g) { gamesList.add(g); }

    public Game getGame(int i) { return gamesList.get(i); }

    public List<Game> getGamesList() { return gamesList; }

    public void editGame(int position, Game game){
        gamesList.set(position, game);
    }

    public void remove(int position) { gamesList.remove(position); }
}
