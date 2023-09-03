package it.craftopoly.co_ranks.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import it.craftopoly.co_ranks.CO_Ranks;
import it.craftopoly.co_ranks.schema.RankEdit;

public class HttpCall
{
    public static String getRank(String username)
    {
        JsonObject response = HttpUtils.get(
                "/users/" + username + "/rank",
                null,
                JsonObject.class
        ).getAsJsonObject();

        return response.get("param").getAsJsonObject().get("name").getAsString();
    }

    public static String upgrade(String uuid, String username)
    {
        JsonObject response = HttpUtils.put(
                "/users/rank/upgrade",
                uuid,
                new RankEdit(username),
                JsonObject.class
        ).getAsJsonObject();

        if(response.get("code").getAsInt() == 404)
            return CO_Ranks.getInstance().getConfig().getString("messages.user_not_found");

        if(response.get("code").getAsInt() == 403)
            return CO_Ranks.getInstance().getConfig().getString("messages.no_enough_permissions");

        if(response.get("code").getAsInt() == 200)
            return CO_Ranks.getInstance().getConfig().getString("messages.rank_successfully_changed")
                .replace("{rank}", response.get("param").getAsString());

        return CO_Ranks.getInstance().getConfig().getString("messages.error");
    }

    public static String downgrade(String uuid, String username)
    {
        JsonObject response = HttpUtils.put(
                "/users/rank/downgrade",
                uuid,
                new RankEdit(username),
                JsonObject.class
        ).getAsJsonObject();

        if(response.get("code").getAsInt() == 404)
            return CO_Ranks.getInstance().getConfig().getString("messages.user_not_found");

        if(response.get("code").getAsInt() == 403)
            return CO_Ranks.getInstance().getConfig().getString("messages.no_enough_permissions");

        if(response.get("code").getAsInt() == 200)
            return CO_Ranks.getInstance().getConfig().getString("messages.rank_successfully_changed")
                    .replace("{rank}", response.get("param").getAsString());

        return CO_Ranks.getInstance().getConfig().getString("messages.error");
    }
}

