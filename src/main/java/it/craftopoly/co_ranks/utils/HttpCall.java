package it.craftopoly.co_ranks.utils;

import com.google.gson.Gson;
import it.craftopoly.co_ranks.schema.Rank;

import java.lang.reflect.Type;

public class HttpCall
{
    public static String getRank(String username)
    {
        Response response = HttpRequest.get("/users/" + username + "/rank");
        if(response == null)
            return "";
        System.out.println(response.getParam());
        Rank rank = new Gson().fromJson(response.getParam().toString(), (Type) Rank.class);
        return rank.getName();
    }
}
