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
        String fixedRank = rank.
                replace("_", " ").
                replace("SBO", "[").
                replace("SBC", "]");
        player.setPlayerListName(" " + fixedRank + " §7" + player.getName());
        player.setDisplayName(fixedRank + " §7" + player.getName());
    }

}
