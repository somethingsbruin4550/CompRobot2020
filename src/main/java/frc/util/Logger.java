package frc.util;

import java.util.ArrayList;

public class Logger
{
    public static ArrayList<String> logs = new ArrayList<String>();

    /**
     * Erases all logs from the ArrayList
     */
    public static void eraseLogs()
    {
        logs = new ArrayList<String>();
    }

    /**
     * Adds a log entry to the logs Arraylist
     * @param str The log to add to the ArrayList
     * @return The number of logs in the ArrayList
     */
    public static int logString(String str)
    {
        logs.add(str);
        return logs.size();
    }

    /**
     * Writes the logs in the ArrayList to a file
     * @param filePath The path of the log file that will be written
     * @return The number of logs in the ArrayList
     */
    public static int outputToFile(String filePath)
    {
        return logs.size();
    }
}