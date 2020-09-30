package io.github.nolanwinter.amongusv2;


import org.bukkit.entity.Player;

public class AUGame {

    AUPlayer[] playerList = new AUPlayer[10];


    public boolean addPlayer(Player p) {
        boolean added = false;
        for(int i = 0; i < playerList.length; i++) {
            if(playerList[i] == null) {
                playerList[i] = new AUPlayer(p);
                break;
            }
        }
        if(!added) {
            p.sendTitle("Game is Full", "", 2, 20, 2);
            return false;
        }
        return true;
    }

    public void removePlayer(Player p) {
        for(int i = 0; i < playerList.length; i++) {
            if(playerList[i].getPLayer() == p) {
                playerList[i] = null;
                break;
            }
        }
    }
}
