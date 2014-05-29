/*
 * David Zima
 * created 5.22.14
 * CS 182 Lab Project 6 Hash Crash
 * 
 * 
 */

package hashcrash;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import models.DataItem;

import models.HashTable;
import models.ToonArray;

/**
 *
 * @author David
 */
public class HashCrash extends JFrame implements ActionListener {

    private static int win_xpos=0,win_ypos=0;// place window here
    private static int win_xsize=700,win_ysize=500;//  window size

    // Private state variables.

    private JButton hashbutton,exitbutton;
    private JPanel northPanel;
    private MyJPanel centerPanel;
    private JTextField hashsizefield;
    private String thetext = "101";


    ////////////MAIN////////////////////////

    public static void main(String[] args) {
            HashCrash tpo  = new HashCrash();

            tpo.addWindowListener(new WindowAdapter() {   // this exits the program when X box clicked
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    }

    ////////////CONSTRUCTOR/////////////////////

    public HashCrash ()  {
           northPanel = new JPanel();
           northPanel.add(new Label("Enter a hashtable size: "));
           hashsizefield = new JTextField(thetext,20);
           northPanel.add(hashsizefield);
           hashbutton = new JButton("Create Hash");
           northPanel.add(hashbutton);
           hashbutton.addActionListener(this);
           exitbutton = new JButton("Exit");
           northPanel.add(exitbutton);
           exitbutton.addActionListener(this);
           getContentPane().add("North",northPanel);
           centerPanel = new MyJPanel(hashsizefield.getText());
           getContentPane().add("Center",centerPanel);

           // need more init stuff? try here.
           setSize(win_xsize,win_ysize);
           setLocation(win_xpos,win_ypos);
           setVisible(true);
    }

    ////////////BUTTON CLICKS ///////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exitbutton) {
              dispose(); System.exit(0);
        }

        if (e.getSource()==hashbutton) {
              thetext = hashsizefield.getText();
              
              int fieldInt;
              try {
                  fieldInt = Integer.parseInt(thetext);
              } catch (Exception ex) {
                  ex.printStackTrace();
              }
              
              centerPanel.setText(thetext);
              repaint();
        }
    } // end actionPerformed
    
    private HashTable createHashTable(int tableSize)
    {
        HashTable hashTable = new HashTable(tableSize);
        
        String[] toonNames = ToonArray.getNames();
        for (int i = 0; i < toonNames.length; i++)
        {
            DataItem newItem = new DataItem(toonNames[i]);
            hashTable.insert(newItem);
        }
        
        return hashTable;
    }
}