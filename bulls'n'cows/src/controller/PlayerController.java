package controller;

import model.Player;

/**
 * Created by khoAK on 06.04.2016.
 */
public class PlayerController {
    private Player player;
    private boolean turn;

    public PlayerController(Player player, boolean turn) {
        this.player = player;
        this.turn = turn;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}
