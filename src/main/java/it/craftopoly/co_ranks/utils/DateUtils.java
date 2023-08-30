package it.craftopoly.co_ranks.utils;

public class DateUtils
{
    public static String fixDate(String date)
    {
        String[] dates = date.split("-");
        return dates[2] + "/" + dates[1] + "/" + dates[0];
    }
}
