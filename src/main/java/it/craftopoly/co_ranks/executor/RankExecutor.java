package it.craftopoly.co_ranks.executor;

import it.craftopoly.co_ranks.CO_Ranks;
import it.craftopoly.co_ranks.utils.HttpCall;
import it.craftopoly.co_ranks.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankExecutor implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        if(cmd.getName().equals("rank"))
            if(args.length > 0)
            {
                if(args[0].equals("upgrade")){
                    if(args.length == 2)
                    {
                        Player targetPlayer = Bukkit.getPlayer(args[1]);
                        if(targetPlayer != null)
                        {
                            String res = HttpCall.upgrade(player.getUniqueId().toString(), targetPlayer.getName());
                            player.sendMessage(res);

                            if(Utils.isSuccess(res))
                                if(res.contains("Founder"))
                                    targetPlayer.setOp(true);
                        }else{
                            player.sendMessage(CO_Ranks.getInstance().getConfig().getString("messages.user_not_found"));
                        }
                    }
                }

                if(args[0].equals("downgrade")){
                    if(args.length == 2)
                    {
                        Player targetPlayer = Bukkit.getPlayer(args[1]);
                        if(targetPlayer != null)
                        {
                            String res = HttpCall.downgrade(player.getUniqueId().toString(), targetPlayer.getName());
                            player.sendMessage(res);

                            if(Utils.isSuccess(res))
                                if(res.contains("Admin"))
                                    targetPlayer.setOp(false);
                        }else{
                            player.sendMessage(CO_Ranks.getInstance().getConfig().getString("messages.user_not_found"));
                        }
                    }
                }
            }
        return false;
    }
}

