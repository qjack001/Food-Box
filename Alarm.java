import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;
import java.util.ArrayList;

/**
 *  Alarm Object
 *
 *  Object stores the desired feeding time.
 *
 *  @author Jack Guinane, Quinn Smith
 *  @version 1.0
 */

public class Alarm
{
    private int h; //hours
    private int m; //minutes
    private boolean am; //AM/PM
    
    /**
     * null constructor
     * sets time to 12:00 am
     */
    public Alarm()
    {
        h = 0;
        m = 0;
        am = true;
    }
    
    /**
     * 12-hour constructor
     * @param  hour 1 - 12 hour set
     * @param  min  0 - 59 minute set
     * @param  isAM AM or PM (AM if true)
     */
    public Alarm(int hour, int min, boolean isAM)
    {
        h = (hour == 12)? 0 : hour;
        h += isAM ? 0 : 12;
        m = min;
        am = isAM;
    }
    
    /**
     * 24-hour constructor
     * @param  hour24 1 - 24 hour set
     * @param  min    0 - 59 minute set
     */
    public Alarm(int hour24, int min)
    {
        h = hour24;
        m = min;
        am = (hour24 < 12)? true : false;
    }
    
    /**
     * ascii-code constructor
     * @param  asciiTime time in base-34 (see Convert.java)
     */
    public Alarm(String asciiTime)
    {
        h = Convert.asciiToTime("" + asciiTime.charAt(0));
        m = Convert.asciiToTime("" + asciiTime.charAt(1));
        am = (h < 12)? true : false;
    }
    
    /**
     * ascii time (base-34) getter 
     * @return String containing ascii time
     */
    public String getAscii()
    {
        return Convert.timeToAscii(h) + Convert.timeToAscii(m);
    }
    
    /**
     * hour getter
     * @return String containing hour in 12-hour format
     */
    public String getHour()
    {
        String out = "";
        out += am ? h : (((h - 12) == 0)? 12 : (h - 12));
        return out;
    }
    
    /**
     * minute getter
     * @return String containing minute
     */
    public String getMin()
    {
        String out = "";
        out += m;
        return out;
    }
    
    /**
     * AM getter
     * @return Boolean true if AM, false if PM
     */
    public boolean isAM()
    {
        return am;
    }
    
}
