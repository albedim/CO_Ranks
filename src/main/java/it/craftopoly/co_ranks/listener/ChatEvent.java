package it.craftopoly.co_ranks.listener;

import com.google.gson.JsonObject;
import it.craftopoly.co_ranks.utils.DateUtils;
import it.craftopoly.co_ranks.utils.HttpCall;
import it.craftopoly.co_ranks.utils.Utils;
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

        JsonObject res = HttpCall.getMute(player.getName());

        if(res.get("param") != null){
            JsonObject mute = res.get("param").getAsJsonObject();
            e.setCancelled(true);
            sendMessage(player, mute);
        }

    }

    private static void sendMessage(Player player, JsonObject mute)
    {
        player.sendMessage("§8-------------------------------------");
        player.sendMessage(
                "§a§lMute\n\n §7Sei stato mutato, non puoi scrivere in chat.\n" +
                        " §8 ▪ §7Mutato da: §a"+mute.get("muted_by").getAsJsonObject().get("username").getAsString()+"\n" +
                        " §8 ▪ §7Mutato il: §a"+
                        DateUtils.fixDate(mute.get("muted_on").getAsString().split(" ")[0]) + " " +
                        mute.get("muted_on").getAsString().split(" ")[1].split(":")[0] + ":" +
                        mute.get("muted_on").getAsString().split(" ")[1].split(":")[1]
                        +"\n" +
                        " §8 ▪ §7Fine del mute: §a"+
                        DateUtils.fixDate(mute.get("ends_on").getAsString().split(" ")[0]) + " " +
                        mute.get("ends_on").getAsString().split(" ")[1].split(":")[0] + ":" +
                        mute.get("ends_on").getAsString().split(" ")[1].split(":")[1]
                        +"\n" +
                        " §8 ▪ §7Motivazione: "+mute.get("reason").getAsString()+"\n");
        player.sendMessage("§8-------------------------------------");
    }
}
