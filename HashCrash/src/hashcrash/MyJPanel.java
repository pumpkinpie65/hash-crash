/*
 * David Zima
 * created 5.22.14
 * CS 182 Lab Project 6 Hash Crash
 */

package hashcrash;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class MyJPanel extends JPanel {

    private String theText;
    
    public MyJPanel(String newText) {
        theText = newText;
    }
    
 ////////////    PAINT   ////////////////////////////////
  public void paintComponent (Graphics g) {

         g.setFont(Fonts.plainfont);
         g.drawString("I am paint, field contains " + theText,20,30);

  }
} // End Of MyJPanel

