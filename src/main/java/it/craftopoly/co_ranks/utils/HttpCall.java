package it.craftopoly.co_ranks.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
}
