import java.util.Calendar;

public class Serial
{
    public static void send(String info)
    {
        //send to serial
        System.out.println(info);
    }
    
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
