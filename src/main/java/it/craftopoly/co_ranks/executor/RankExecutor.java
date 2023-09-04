package it.craftopoly.co_ranks.executor;

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
                        String target = args[1];
                        String res = HttpCall.upgrade(player.getUniqueId().toString(), target);
                        player.sendMessage(res);

                        if(Utils.isSuccess(res))
                            if(res.contains("Founder")) {
                                Player targetPlayer = Bukkit.getPlayer(target);
                                targetPlayer.setOp(true);
                            }
                    }
                }

                if(args[0].equals("downgrade")){
                    if(args.length == 2)
                    {
                        String target = args[1];
                        String res = HttpCall.downgrade(player.getUniqueId().toString(), target);
                        player.sendMessage(res);

                        if(Utils.isSuccess(res))
                            if(res.contains("Admin")) {
                                Player targetPlayer = Bukkit.getPlayer(target);
                                targetPlayer.setOp(false);
                            }
                    }
                }
            }
        return false;
    }
}

