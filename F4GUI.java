
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;
import java.util.ArrayList;

/*
 * to add:
 *  >send request when button click
 *  >make timer save to file
 *  >all the other screens
 */

public class F4GUI
{
    private JFrame frame;
    private final Color[] COLOR = {
        new Color(30,136,229), //light blue
        new Color(21,101,192), //dark blue
        new Color(250,250,250)}; //off-white
    private final int WIDTH = 660, HEIGHT = 460;
    
    private AlarmList alarmList;
    private JLabel time;
    private final String RES_PATH = "/Resources/";
    
    
    /*
     *  constructor, but you already knew that 
     */
    public F4GUI()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("FoodBox");
        alarmList = new AlarmList();
        Serial.updateTime();
        gotoPage(feedPage());
    }

    /*
     *  go to a specific page
     */
    private void gotoPage(Container page)
    {
        frame.setContentPane(page);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
    
    /*
     *  calculates time
     */
    private String getTime()
    {
        long now = System.currentTimeMillis();
        //long sec = (now - Long.parseLong(ReadWrite.read(RES_PATH + "settings.txt").get(1))) / 1000;
        //long hour = (sec / 60) / 60;
        //long min = (sec / 60) % 60;
        String out = "4";//String.format("%02d:%02d",hour,min);
        return out;
    }

    /*
     *  returns shadow component
     */
    private Container shadow()
    {
        JPanel sPage = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        sPage.setBackground(COLOR[2]);
        
        ImageIcon shadowIcon = new ImageIcon(RES_PATH + "shadow.png");
        JLabel shadow = new JLabel("", shadowIcon, JLabel.RIGHT);
        sPage.add(shadow);
        
        return sPage;
    }
    
    /*
     *  returns toolBar
     */
    private Container toolBar(int selected)
    {
        JPanel page = new JPanel();
        page.setBackground(COLOR[0]);
        page.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 0));
        page.setLayout(new BoxLayout(page, BoxLayout.PAGE_AXIS));
        
        ImageIcon logoIcon = new ImageIcon(RES_PATH + "logo.png");
        JLabel logo = new JLabel("", logoIcon, JLabel.CENTER);
        Border paddingBorder = BorderFactory.createEmptyBorder(10, 22, 40, 0);
        logo.setBorder(BorderFactory.createCompoundBorder(paddingBorder,paddingBorder));
        page.add(logo);
        
        JButton button1 = new JButton("FEED");
        page.add(button1);
        button1.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        button1.setHorizontalAlignment(SwingConstants.LEFT);
        button1.setMargin(new Insets(5, 23, 5, 59));
        //button1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        button1.setForeground(Color.white);
        //button1.setIcon(new ImageIcon(""));
        button1.setOpaque(true); 
        button1.setBorderPainted(false);
        
        if(1 == selected)
        {
            button1.setBackground(COLOR[1]);
        }
        else
        {
            button1.setBackground(COLOR[0]);
        }
        
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                gotoPage(feedPage());
            }
        });
        
        JButton button2 = new JButton("TIMERS");
        page.add(button2);
        button2.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        button2.setHorizontalAlignment(SwingConstants.LEFT);
        button2.setMargin(new Insets(5, 23, 5, 42));
        //button2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        button2.setForeground(Color.white);
        //button2.setIcon(new ImageIcon(""));
        button2.setOpaque(true); 
        button2.setBorderPainted(false);
        
        if(2 == selected)
        {
            button2.setBackground(COLOR[1]);
        }
        else
        {
            button2.setBackground(COLOR[0]);
        }
        
        button2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                gotoPage(timersPage());
            }
        });
        
        JButton button3 = new JButton("DATA");
        page.add(button3);
        button3.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        button3.setHorizontalAlignment(SwingConstants.LEFT);
        button3.setMargin(new Insets(5, 23, 5, 57));
        //button3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        button3.setForeground(Color.white);
        //button3.setIcon(new ImageIcon(""));
        button3.setOpaque(true); 
        button3.setBorderPainted(false);
        
        if(3 == selected)
        {
            button3.setBackground(COLOR[1]);
        }
        else
        {
            button3.setBackground(COLOR[0]);
        }
        
        button3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                gotoPage(dataPage());
            }
        });
        
        JButton button4 = new JButton("SETTINGS");
        page.add(button4);
        button4.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        button4.setHorizontalAlignment(SwingConstants.LEFT);
        button4.setMargin(new Insets(5, 23, 5, 27));
        //button4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        button4.setForeground(Color.white);
        //button4.setIcon(new ImageIcon(""));
        button4.setOpaque(true); 
        button4.setBorderPainted(false);
        
        if(4 == selected)
        {
            button4.setBackground(COLOR[1]);
        }
        else
        {
            button4.setBackground(COLOR[0]);
        }
        
        button4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                gotoPage(settingsPage());
            }
        });
        
        page.add(Box.createVerticalStrut(24));
        
        return page;
    }
    
    
    private Container addAlarm(final int i)
    {
        final JPanel page = new JPanel();
        page.setBackground(new Color(250,250,250));
        page.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        page.setLayout(new BoxLayout(page, BoxLayout.X_AXIS));
        
        JLabel label = new JLabel(String.format("%d:%02d",
            Integer.parseInt(alarmList.get(i).getHour()),Integer.parseInt(alarmList.get(i).getMin())));
        label.setFont(new Font("Roboto-Light", Font.PLAIN, 28));
        page.add(label);
        
        JLabel amPM = new JLabel();
        amPM.setFont(new Font("Roboto-Medium", Font.BOLD, 12));
        if(alarmList.get(i).isAM())
            amPM.setText("    AM");
        else
            amPM.setText("    PM");
        page.add(amPM);
        
        page.add(Box.createGlue());
        
        ImageIcon icn1 = new ImageIcon(RES_PATH + "create.png");
        JButton addButton = new JButton();
        addButton.setSize(icn1.getImage().getWidth(null),icn1.getImage().getHeight(null));
        addButton.setIcon(icn1);
        addButton.setMargin(new Insets(0,0,0,0));
        addButton.setIconTextGap(0);
        addButton.setBorderPainted(false);
        addButton.setBorder(null);
        addButton.setText(null);
        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String response = Dialog.showNewAlarm(frame);
                if(response != Dialog.CANCEL)
                {
                    boolean am = (response.split(":")[2].equals("am"))?true:false;
                    alarmList.edit(new Alarm(Integer.parseInt(response.split(":")[0]),
                        Integer.parseInt(response.split(":")[1]),am), i);
                    gotoPage(timersPage());
                }
            }
        });
        page.add(addButton);
        
        ImageIcon icn2 = new ImageIcon(RES_PATH + "delete.png");
        JButton addButton2 = new JButton();
        addButton2.setSize(icn2.getImage().getWidth(null),icn2.getImage().getHeight(null));
        addButton2.setIcon(icn2);
        addButton2.setMargin(new Insets(0,0,0,0));
        addButton2.setIconTextGap(0);
        addButton2.setBorderPainted(false);
        addButton2.setBorder(null);
        addButton2.setText(null);
        addButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String decision = Dialog.showConfirm(new JFrame(),"Are you sure you wan" +
                    "t to delete?","The alarm will be permanently deleted. Y" +
                    "ou cannot undo this action.");
                    
                if(decision == Dialog.YES)
                {
                    alarmList.remove(i);
                    gotoPage(timersPage());
                }
            }
        });
        page.add(addButton2);
        
        return page;
    }

    /*
     *  feed manually page
     */
    private Container feedPage()
    {
        JPanel mainPage = new JPanel();
        mainPage.setLayout(new GridBagLayout());
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.fill = GridBagConstraints.HORIZONTAL;
        
        gBC.gridx = 0;
        gBC.gridy = 0;
        mainPage.add(toolBar(1), gBC);
        
        gBC.gridx = 1;
        gBC.gridy = 0;
        mainPage.add(shadow(), gBC);
        
        JPanel page = new JPanel();
        gBC.weightx = 0.5;
        gBC.gridx = 2;
        gBC.gridy = 0;
        mainPage.add(page, gBC);
        
        page.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 10));
        page.setLayout(new BoxLayout(page, BoxLayout.PAGE_AXIS));
        page.setBackground(COLOR[2]);
        
        page.add(Box.createVerticalStrut(5));
        
        ImageIcon feedIcn = new ImageIcon(RES_PATH + "feedbutton.png");
        JButton fButton = new JButton();
        fButton.setSize(feedIcn.getImage().getWidth(null),feedIcn.getImage().getHeight(null));
        fButton.setIcon(feedIcn);
        fButton.setMargin(new Insets(0,0,0,0));
        fButton.setIconTextGap(0);
        fButton.setBorderPainted(false);
        fButton.setBorder(null);
        fButton.setText(null);
        fButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        page.add(fButton);
        fButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Serial.send("m");
                ReadWrite.write(ReadWrite.read(RES_PATH + "settings.txt").get(0) + 
                    "\n" + System.currentTimeMillis(), RES_PATH + "settings.txt");
            }
        });
        
        JLabel info = new JLabel("TIME SINCE LAST FEED");
        info.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        page.add(info);
        
        page.add(Box.createVerticalStrut(10));
        
        time = new JLabel(getTime());
        time.setFont(new Font("Roboto-Medium", Font.BOLD, 40));
        time.setAlignmentX(Component.CENTER_ALIGNMENT);
        time.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        page.add(time);
        ActionListener taskPerformer = new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                time.setText(getTime());
            }
        };
        Timer t = new Timer(1000, taskPerformer);
        t.start();
        
        page.add(Box.createVerticalStrut(500));
        return mainPage;
    }
    
    /*
     *  set timers page
     */
    private Container timersPage()
    {
        JPanel mainPage = new JPanel();
        mainPage.setLayout(new GridBagLayout());
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.fill = GridBagConstraints.HORIZONTAL;
        
        gBC.gridx = 0;
        gBC.gridy = 0;
        mainPage.add(toolBar(2), gBC);
        
        gBC.gridx = 1;
        gBC.gridy = 0;
        mainPage.add(shadow(), gBC);
        
  
        JPanel page = new JPanel();
        page.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));
        page.setBackground(COLOR[2]);

        for(int i = 0; i < alarmList.size(); i++)
            page.add(addAlarm(i));
        
        
        page.add(Box.createVerticalStrut(10));
        
        ImageIcon icn = new ImageIcon(RES_PATH + "add.png");
        JButton addButton = new JButton();
        addButton.setSize(icn.getImage().getWidth(null),icn.getImage().getHeight(null));
        addButton.setIcon(icn);
        addButton.setMargin(new Insets(0,0,0,0));
        addButton.setIconTextGap(0);
        addButton.setBorderPainted(false);
        addButton.setBorder(null);
        addButton.setText(null);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        page.add(addButton);
        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String response = Dialog.showNewAlarm(frame);
                if(response != Dialog.CANCEL)
                {
                    boolean am = (response.split(":")[2].equals("am"))?true:false;
                    alarmList.add(new Alarm(Integer.parseInt(response.split(":")[0]),
                        Integer.parseInt(response.split(":")[1]),am));
                    gotoPage(timersPage());
                }
            }
        });
        
        JScrollPane panel = new JScrollPane(page);
        panel.getVerticalScrollBar().setUnitIncrement(5);
        panel.setBorder(null);
        
        gBC.weightx = 0.5;
        gBC.gridx = 2;
        gBC.gridy = 0;
        gBC.fill = GridBagConstraints.BOTH;
        gBC.anchor = GridBagConstraints.NORTH;
        mainPage.add(panel,gBC);
        
        
        return mainPage;
    }
    
    /*
     *  get data page
     */
    private Container dataPage()
    {
        JPanel page = new JPanel();
        page.setBackground(COLOR[2]);
        page.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        page.add(toolBar(3),g);
        g.gridx = 1;
        g.gridy = 0;
        page.add(shadow(), g);
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 2;
        g.gridy = 0;
        g.weightx = 1.0;
        g.weighty = 1.0;
        page.add(Box.createGlue(), g);
        return page;
    }
    
    /*
     *  adjust settings page
     */
    private Container settingsPage()
    {
        JPanel page = new JPanel();
        page.setBackground(COLOR[2]);
        page.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        page.add(toolBar(4),g);
        g.gridx = 1;
        g.gridy = 0;
        page.add(shadow(), g);
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 2;
        g.gridy = 0;
        g.weightx = 1.0;
        g.weighty = 1.0;
        page.add(Box.createGlue(), g);
        return page;
    }
}