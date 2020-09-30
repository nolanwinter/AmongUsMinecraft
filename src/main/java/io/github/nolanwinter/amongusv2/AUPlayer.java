package io.github.nolanwinter.amongusv2;

import org.bukkit.entity.Player;

public class AUPlayer {

    private Player p;
    private String name;

    public AUPlayer(Player _p) {
        p = _p;
    }

    public Player getPLayer() {
        return p;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}
