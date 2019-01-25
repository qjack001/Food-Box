
/**
 *  Format Converting Object
 *
 *  Extremely simple helper class to convert decimal into 34-base.
 *  Thus allowing the entire ascii range to be used, saving space.
 *
 *  @author Jack Guinane, Quinn Smith
 *  @version 1.0
 */

public class Convert
{
    /**
     * converts time (base-10) to ascii (base-34)
     * @param  num input (base-10)
     * @return     String containing converted ascii
     */
    public static String timeToAscii(int num)
    {
        char out;
        out = (char)(num + 34);
        return "" + out;
    }
    
    /**
     * converts ascii (base-34) to time (base-10)
     * @param  String   input (base-34)
     * @return          int base-10
     */
    public static int asciiToTime(String num)
    {
        int out;
        out = (int)(num.charAt(0) - 34);
        return out;
    }
}
