/*
 * David Zima
 * created 5.29.14
 * CS 182 Lab Project 6 Hash Crash
 */

package models;

/**
 *
 * @author David
 */
public class Crash {
    
    private final String name;
    private final int shouldBePosition;
    private final int foundAtPosition;
    
    public Crash(String theName, int theShouldBePosition, int theFoundAtPosition)
    {
        name = theName;
        shouldBePosition = theShouldBePosition;
        foundAtPosition = theFoundAtPosition;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getShouldBePosition()
    {
        return shouldBePosition;
    }
    
    public int getFoundAtPosition()
    {
        return foundAtPosition;
    }
}
