package it.craftopoly.co_ranks.listener;

import it.craftopoly.co_ranks.utils.HttpCall;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e)
    {
        Player player = e.getPlayer();
        String rank = HttpCall.getRank(player.getName());
        e.setFormat(rank + " §7" + player.getName() + " §8➜ §7" + e.getMessage());
    }

}
