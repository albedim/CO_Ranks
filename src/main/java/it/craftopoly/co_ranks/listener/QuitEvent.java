package it.craftopoly.co_ranks.listener;

import it.craftopoly.co_ranks.utils.HttpCall;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        e.setQuitMessage(null);
        Player player = e.getPlayer();
        String rank = HttpCall.getRank(player.getName());
        player.setPlayerListName(" " + rank + " §7" + player.getName());
        player.setDisplayName(rank + " §7" + player.getName());
    }

}
