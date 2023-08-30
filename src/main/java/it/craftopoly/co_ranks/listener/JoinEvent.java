package it.craftopoly.co_ranks.listener;

import it.craftopoly.co_ranks.utils.HttpCall;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        String rank = HttpCall.getRank(player.getName());
        player.setPlayerListName(" " + rank.replace("SBO", "[").replace("SBC", "]") + " §7" + player.getName());
        player.setDisplayName(rank.replace("SBO", "[").replace("SBC", "]") + " §7" + player.getName());
    }

}
