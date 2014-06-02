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
    private ArrayList<Crash> crashes = new ArrayList<Crash>();
    
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

    int xPos = 20;
    int yPos = 30;
      
    g.setFont(Fonts.plainfont);
    //g.drawString("I am paint, field contains " + theText, xPos, yPos);
    g.drawString("Hash Crash count is " + crashes.size(), xPos, yPos);

    if (crashes != null)
    {
        for (int i = 0; i < crashes.size(); i++)
        {
            String stringToPrint = "Hash Crash: " + crashes.get(i).getName() + "        " +
                    "should be at   " + crashes.get(i).getShouldBePosition() + "    " +
                    "found at   " + crashes.get(i).getFoundAtPosition();
            g.drawString(stringToPrint, xPos, yPos += 30);
        }
    }
  }
} // End Of MyJPanel

