/*
 * David Zima
 * created 5.22.14
 * CS 182 Lab Project 6 Hash Crash
 */

package hashcrash;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.Crash;

/**
 *
 * @author David
 */
public class MyJPanel extends JPanel {

    private String theText;
    private ArrayList<Crash> crashes;
    
    public MyJPanel(String newText) {
        theText = newText;
    }
    
    public void setText(String newText)
    {
        theText = newText;
    }
    
    public void setCrashes(ArrayList<Crash> theCrashes)
    {
        crashes = theCrashes;
    }
    
 ////////////    PAINT   ////////////////////////////////
  public void paintComponent (Graphics g) {

         g.setFont(Fonts.plainfont);
         g.drawString("I am paint, field contains " + theText,20,30);

  }
} // End Of MyJPanel

