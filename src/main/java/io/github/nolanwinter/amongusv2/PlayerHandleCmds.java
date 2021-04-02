package io.github.nolanwinter.amongusv2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.inventivetalent.mcwrapper.auth.GameProfileWrapper;
import org.inventivetalent.nicknamer.api.NickManager;
import org.inventivetalent.nicknamer.api.NickNamerAPI;
import org.inventivetalent.nicknamer.api.SkinLoader;

import java.util.Collection;

public class PlayerHandleCmds implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("addplayer")) {
            if(args.length > 0 ) {
                Collection<Player> oPl = (Collection<Player>) Bukkit.getOnlinePlayers();
                for (Player p : oPl) {
                    if (p.getName().equals(args[0])) {
                        Globals.game.addPlayer(p);
                        return true;
                    }
                }
            }
        } else if(command.getName().equals("removeplayer")) {
            if(args.length > 0 ) {
                Collection<Player> oPl = (Collection<Player>) Bukkit.getOnlinePlayers();
                for (Player p : oPl) {
                    if (p.getName().equals(args[0])) {
                        Globals.game.removePlayer(p);
                        return true;
                    }
                }
            }
        } else if(command.getName().equals("setname")) {
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
        } else if(command.getLabel().equals("setskin")) {
            if(args.length > 1 ) {
                Collection<Player> oPl = (Collection<Player>) Bukkit.getOnlinePlayers();
                for (Player p : oPl) {
                    if (p.getName().equals(args[0])) {
                        String skin = "EaveBeats";
                        sender.sendMessage(p.getDisplayName());
                        sender.sendMessage(p.getUniqueId().toString());
                        GameProfileWrapper cusSkin = SkinLoader.getSkinProfile(skin);
                        NickNamerAPI.getNickManager().loadCustomSkin("testS", cusSkin);
                        NickNamerAPI.getNickManager().setCustomSkin(p.getUniqueId(), "testS");
                        return true;
                    } else {
                        sender.sendMessage("Not Online");
                    }
                }
            } else {
                sender.sendMessage("more args plz");
            }
        }
        return false;
    }
}
