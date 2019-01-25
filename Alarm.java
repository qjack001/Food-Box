
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;
import java.util.ArrayList;

public class Alarm
{
    private int h;
    private int m;
    private boolean am;
    
    public Alarm()
    {
        h = 0;
        m = 0;
        am = true;
    }
    
    public Alarm(int hour, int min, boolean isAM)
    {
        h = (hour == 12)? 0 : hour;
        h += isAM ? 0 : 12;
        m = min;
        am = isAM;
    }
    
    public Alarm(int hour24, int min)
    {
        h = hour24;
        m = min;
        am = (hour24 < 12)? true : false;
    }
    
    public Alarm(String asciiTime)
    {
        h = Convert.asciiToTime("" + asciiTime.charAt(0));
        m = Convert.asciiToTime("" + asciiTime.charAt(1));
        am = (h < 12)? true : false;
    }
    
    public String getAscii()
    {
        return Convert.timeToAscii(h) + Convert.timeToAscii(m);
    }
    
    public String getHour()
    {
        String out = "";
        out += am ? h : (((h - 12) == 0)? 12 : (h - 12));
        return out;
    }
    
    public String getMin()
    {
        String out = "";
        out += m;
        return out;
    }
    
    public boolean isAM()
    {
        return am;
    }
    
}
