/*
 * David Zima
 * created 5.27.14
 * CS 182 Lab Project 6 Hash Crash
 */

package models;

/**
 *
 * @author David
 */
public class DataItem {
    
    private String key;
    
    public DataItem(String newKey)
    {
        key = newKey;
    }
    
    public String getKey()
    {
        return key;
    }
}
