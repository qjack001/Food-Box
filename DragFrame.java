import javax.swing.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
public class DragFrame extends JDialog {

  int mpX, mpY;

  public DragFrame(JFrame p, boolean t) {
      super(p,t);
      
    addMouseListener( new MouseAdapter() {
        @Override
        public void mousePressed( MouseEvent e ) {
          mpX = e.getX();
          mpY = e.getY();
        }
    } );

    addMouseMotionListener( new MouseMotionAdapter() {
        @Override
        public void mouseDragged( MouseEvent e ) {
          setLocation(
              getLocation().x + e.getX() - mpX,
              getLocation().y + e.getY() - mpY );
        }
    } );
  }
}