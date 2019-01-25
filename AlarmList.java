import java.util.ArrayList;

public class AlarmList
{
    private final String FILENAME = "/Resources/alarms.txt";
    private ArrayList<Alarm> alarms;
    
    public AlarmList()
    {
        ArrayList<String> file = ReadWrite.read(FILENAME);
        alarms = new ArrayList<Alarm>();
        
        for(String time : file)
        {
            alarms.add(new Alarm(time));
        }
    }
    
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
    
    private void save()
    {
        ReadWrite.write(alarms, FILENAME);
        Serial.send(all());
    }
    
    public void remove(int index)
    {
        alarms.remove(index);
        save();
    }
    
    public void add(Alarm newAlarm)
    {
        alarms.add(newAlarm);
        save();
    }
    
    public void edit(Alarm newAlarm, int index)
    {
        alarms.remove(index);
        alarms.add(index, newAlarm);
        save();
    }
    
    public Alarm get(int index)
    {
        return alarms.get(index);
    }
    
    public int size()
    {
        return alarms.size();
    }
}
