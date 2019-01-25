
/**
 *   ___  ___   ___  __ __    
 *    ||  /\\  //  ' ||_/    [Jack Guinane] 
 *  \_|/ /--\\ \\__/ || \\,  [DATE]
 *   ___, __  _ ____ __  _  ___  __  _ ____,
 *  // __ ||  |  ||  ||\ |  /\\  ||\ | ||_ '
 *  \\__/ \\__/ _||_ || \| /--\\ || \| ||__,
 *  
 *  Description goes here.
 *  -----
 *  Things to fix: bugs go here.
 *  -----
 *  Add methods and how-to to this comment.  
 */

public class Convert
{
    public static String timeToAscii(int num)
    {
        char out;
        out = (char)(num + 34);
        return "" + out;
    }
    
    public static int asciiToTime(String num)
    {
        int out;
        out = (int)(num.charAt(0) - 34);
        return out;
    }
}
