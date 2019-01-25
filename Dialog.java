
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;
import java.util.ArrayList;
import java.awt.event.WindowEvent;

public class Dialog
{
    private static DragFrame dialog;
    private static String inputValue;
    
    public static final String YES = "$yes";
    public static final String NO = "$no";
    public static final String CANCEL = "$cancel";
    public static final String OK = "$ok";

    public static void main(String[] args)
    {
        System.out.println(showNewAlarm(new JFrame()));
    }
    
    public static String showNewAlarm(JFrame parent) 
    {
        dialog = new DragFrame(parent, true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setUndecorated(true);
        int w = 300;
        int h = 200;
        
        JPanel page = new JPanel();
        page.setBackground(new Color(255,255,255));
        page.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        page.setLayout(new BoxLayout(page, BoxLayout.PAGE_AXIS));
        
        JPanel textPage = new JPanel((new FlowLayout(FlowLayout.LEFT)));
        textPage.setBackground(new Color(255,255,255));
        textPage.setBorder(BorderFactory.createEmptyBorder(17,17,0,17));
        ((FlowLayout)textPage.getLayout()).setVgap(0);
        
        JLabel titleL = new JLabel("<html><p>Set alarm time</p></html>");
        titleL.setFont(new Font("Roboto-Medium", Font.BOLD, 20));
        textPage.add(titleL);
        JLabel sub = new JLabel("<html><p><br>Enter the time you want the cat to be fed.</p></html>");
        sub.setFont(new Font("Roboto", Font.PLAIN, 14));
        sub.setForeground(new Color(70,70,70));
        textPage.add(sub);
        
        
        JPanel timeP = new JPanel();
        timeP.setBackground(new Color(255,255,255));
        timeP.setBorder(BorderFactory.createEmptyBorder(0,17,0,17));
        timeP.setLayout(new BoxLayout(timeP, BoxLayout.X_AXIS));
        String[] hours = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        final JComboBox time1 = new JComboBox(hours);
        time1.setSelectedIndex(0);
        String[] mins = {"00","01","02","03","04","05","06","07","08","09","10","11",
            "12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
            "27","28","29","30","31","32","33","34","35","36","37","38","39","40","41",
            "42","43","44","45","46","47","48","49","50","51","52","53","54","55","56",
            "57","58","59"};
        final JComboBox time2 = new JComboBox(mins);
        time2.setSelectedIndex(0);
        String[] amPm = {"am","pm"};
        final JComboBox time3 = new JComboBox(amPm);
        time3.setSelectedIndex(0);
        
        JLabel colon = new JLabel(":");
        colon.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        
        timeP.add(time1);
        timeP.add(colon);
        timeP.add(time2);
        timeP.add(Box.createHorizontalStrut(5));
        timeP.add(time3);
        
        JPanel pageB = new JPanel();
        pageB.setBackground(new Color(255,255,255));
        pageB.setBorder(BorderFactory.createEmptyBorder(6, 6, 18, 8));
        pageB.setLayout(new BoxLayout(pageB, BoxLayout.X_AXIS));
        
        pageB.add(Box.createHorizontalGlue());
        
        JButton button1 = new JButton("CANCEL");
        pageB.add(button1);
        button1.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        button1.setMargin(new Insets(0,0,0,-25));
        button1.setForeground(new Color(30,136,229));
        button1.setBackground(new Color(255,255,255));
        button1.setOpaque(true); 
        button1.setBorderPainted(false);
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                inputValue = CANCEL;
                dialog.dispose();
            }
        });
        
        JButton button2 = new JButton("OK");
        pageB.add(button2);
        button2.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        button2.setMargin(new Insets(0,0,0,0));
        button2.setForeground(new Color(30,136,229));
        button2.setBackground(new Color(255,255,255));
        button2.setOpaque(true); 
        button2.setBorderPainted(false);
        button2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                inputValue = (time1.getSelectedItem() + ":" + 
                    time2.getSelectedItem() + ":" + time3.getSelectedItem());
                dialog.dispose();
            }
        });
        
        page.add(textPage);
        page.add(timeP);
        page.add(pageB);
        
        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        inputValue = null;
        dialog.add(page);
        dialog.setSize(w, h);
        dialog.setVisible(true);
        
        return inputValue;
    }
    
    public static String showConfirm(JFrame parent, String title, String message) 
    {
        dialog = new DragFrame(parent, true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setUndecorated(true);
        int w = 300;
        int h = 200;
        
        JPanel page = new JPanel();
        page.setBackground(new Color(255,255,255));
        page.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        page.setLayout(new GridBagLayout());
        GridBagConstraints gBC = new GridBagConstraints();
        
        JPanel textPage = new JPanel();
        textPage.setBackground(new Color(255,255,255));
        textPage.setBorder(BorderFactory.createEmptyBorder(0,17,0,17));
        textPage.setLayout(new BoxLayout(textPage, BoxLayout.PAGE_AXIS));
        
        JLabel titleL = new JLabel("<html><p>" + title + "</p></html>");
        titleL.setFont(new Font("Roboto-Medium", Font.BOLD, 20));
        textPage.add(titleL);
        textPage.add(Box.createVerticalStrut(18));
        JLabel messageL = new JLabel("<html><p>" + message + "</p></html>");
        messageL.setFont(new Font("Roboto", Font.PLAIN, 14));
        messageL.setForeground(new Color(70,70,70));
        textPage.add(messageL);
        
        JPanel pageB = new JPanel();
        pageB.setBackground(new Color(255,255,255));
        pageB.setBorder(BorderFactory.createEmptyBorder(6, 6, 0, 6));
        pageB.setLayout(new BoxLayout(pageB, BoxLayout.X_AXIS));
        
        pageB.add(Box.createHorizontalStrut(150));
        
        JButton button1 = new JButton("NO");
        pageB.add(button1);
        button1.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        button1.setMargin(new Insets(0,0,0,-25));
        button1.setForeground(new Color(30,136,229));
        button1.setBackground(new Color(255,255,255));
        button1.setOpaque(true); 
        button1.setBorderPainted(false);
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                inputValue = NO;
                dialog.dispose();
            }
        });
        
        JButton button2 = new JButton("YES");
        pageB.add(button2);
        button2.setFont(new Font("Roboto-Medium", Font.BOLD, 14));
        //button2.setMargin(new Insets(0,0,0,0));
        button2.setForeground(new Color(30,136,229));
        button2.setBackground(new Color(255,255,255));
        button2.setOpaque(true); 
        button2.setBorderPainted(false);
        button2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                inputValue = YES;
                dialog.dispose();
            }
        });
        
        JPanel split = new JPanel();
        split.setBackground(new Color(255,255,255));
        split.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        split.setLayout(new BoxLayout(split, BoxLayout.X_AXIS));
        
        gBC.fill = GridBagConstraints.BOTH;
        
        gBC.gridx = 0;
        gBC.gridy = 0;
        page.add(textPage,gBC);
        gBC.gridx = 0;
        gBC.gridy = 1;
        page.add(split,gBC);
        gBC.gridx = 0;
        gBC.gridy = 2;
        page.add(pageB,gBC);
        
        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        inputValue = null;
        dialog.add(page);
        dialog.setSize(w, h);
        dialog.setVisible(true);
        
        return inputValue;
    }
}