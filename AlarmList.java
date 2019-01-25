import java.util.ArrayList;

/**
 *  Alarm List Object
 *
 *  Object that contains the list of scheduled alarms.
 *
 *  @author Jack Guinane, Quinn Smith
 *  @version 1.0
 */

public class AlarmList
{
    private final String FILENAME = "/Resources/alarms.txt"; //path to stored data
    private ArrayList<Alarm> alarms; //list of alarms (see Alarm.java)
    
    /**
     * constructor
     * creates new list, adding all alarms currently stored in /Resources/alarms.txt
     */
    public AlarmList()
    {
        ArrayList<String> file = ReadWrite.read(FILENAME);
        alarms = new ArrayList<Alarm>();
        
        for(String time : file)
        {
            alarms.add(new Alarm(time));
        }
    }
    
    /**
     * returns all alarms stored in base-34 format
     * @return String containing all alarms
     */
    public String all()
    {
        String out = "t";
        for(Alarm time : alarms)
        {
            out += time.getAscii();
        }
        out += "a";
        
        return out;
    }
    
    /**
     * writes all alarms to file, sends the to Arduino
     */
    private void save()
    {
        ReadWrite.write(alarms, FILENAME);
        Serial.send(all());
    }
    
    /**
     * removes alarm from list
     * @param index the index of the alarm to be removed
     */
    public void remove(int index)
    {
        alarms.remove(index);
        save();
    }
    
    /**
     * adds alarm to list
     * @param newAlarm Alarm object to add
     */
    public void add(Alarm newAlarm)
    {
        alarms.add(newAlarm);
        save();
    }
    
    /**
     * replaces alarm at index
     * @param newAlarm new alarm
     * @param index    index to make changes at
     */
    public void edit(Alarm newAlarm, int index)
    {
        alarms.remove(index);
        alarms.add(index, newAlarm);
        save();
    }
    
    /**
     * returns alarm at index
     * @param  index position of alarm
     * @return       Alarm
     */
    public Alarm get(int index)
    {
        return alarms.get(index);
    }
    
    /**
     * size getter
     * @return int size of Alarm list
     */
    public int size()
    {
        return alarms.size();
    }
}
