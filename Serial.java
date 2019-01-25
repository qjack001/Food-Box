import java.util.Calendar;

/**
 *  Serial Connection Object
 *
 *  Previously sent information to the Arduino board over serial connection.
 *  IMPORTANT: This functionality has been removed, as the serial port no longer works,
 *  it now prints the desired output to the console for reference purposes.
 *
 *  @author Jack Guinane, Quinn Smith
 *  @version 2.0
 */

public class Serial
{
    /**
     * sends information through serial port
     * !! removed !!
     * @param info String containing information to send
     */
    public static void send(String info)
    {
        //send to serial
        System.out.println(info);
    }
    
    /**
     * updates Arduino with current time
     */
    public static void updateTime()
    {
        Calendar now = Calendar.getInstance();
        String date = "d";
        date += Convert.timeToAscii(now.get(Calendar.SECOND));
        date += Convert.timeToAscii(now.get(Calendar.MINUTE));
        date += Convert.timeToAscii(now.get(Calendar.HOUR_OF_DAY));
        date += Convert.timeToAscii(now.get(Calendar.DAY_OF_MONTH));
        date += Convert.timeToAscii(now.get(Calendar.MONTH));
        //send to serial
        System.out.println(date);
    }
}
