package it.craftopoly.co_ranks.utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public final class Utils
{
    public static boolean isSuccess(String message)
    {
        return message.startsWith("§a");
    }

    public static String convertObjectToJson(Object obj) {
        try {
            Gson gson = new Gson();
            return gson.toJson(obj); // Convert object to JSON string
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isUsernamePremium(String username) throws IOException, MalformedURLException {
        URL url = new URL("https://api.mojang.com/users/profiles/minecraft/"+username);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = in.readLine())!=null){
            result.append(line);
        }
        return !result.toString().equals("");
    }
}
