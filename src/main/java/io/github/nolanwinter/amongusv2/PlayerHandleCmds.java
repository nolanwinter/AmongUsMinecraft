package io.github.nolanwinter.amongusv2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickNamerAPI;

import java.util.Collection;

public class PlayerHandleCmds implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName() == "addplayer") {
            if(args.length > 0 ) {
                Collection<Player> oPl = (Collection<Player>) Bukkit.getOnlinePlayers();
                for (Player p : oPl) {
                    if (p.getName().equals(args[0])) {
                        Globals.game.addPlayer(p);
                        return true;
                    }
                }
            }
        } else if(command.getName() == "removeplayer") {
            if(args.length > 0 ) {
                Collection<Player> oPl = (Collection<Player>) Bukkit.getOnlinePlayers();
                for (Player p : oPl) {
                    if (p.getName().equals(args[0])) {
                        Globals.game.removePlayer(p);
                        return true;
                    }
                }
            }
        } else if(command.getName() == "setname") {
            if(args.length > 0 ) {
                Collection<Player> oPl = (Collection<Player>) Bukkit.getOnlinePlayers();
                for (Player p : oPl) {
                    if (p.getName().equals(args[0])) {
                        String nick = "";
                        if(args.length > 1) {
                            nick = args[1];
                        } else {
                            nick = p.getName();
                        }
                        NickNamerAPI.getNickManager().setNick(p.getUniqueId(), nick);
                        return true;
                    }
                }
            }
        } else if(command.getName() == "setskin") {
            if(args.length > 1 ) {
                Collection<Player> oPl = (Collection<Player>) Bukkit.getOnlinePlayers();
                for (Player p : oPl) {
                    if (p.getName().equals(args[0])) {
                        String skin = "2056214450";
                        NickNamerAPI.getNickManager().setCustomSkin(p.getUniqueId(), skin);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
