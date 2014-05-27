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
public class HashTable {
    
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;   //for deleted items
    
    public HashTable(int size)  //contstructor
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);     //deleted item key is -1
    }
    
    public void displayTable()
    {
        System.out.print("Table: ");
        for(int j = 0; j < arraySize; j++)
        {
            if (hashArray[j] != null)
            {
                System.out.print(hashArray[j].getKey() + " ");
            }
            else
            {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }
    
    public int hashFunc(int key)
    {
        return key % arraySize;
    }
    
    /**
     * NOTE: assumes table is not full
     * @param item 
     */
    public void insert(DataItem item)
    {
        //assumes table not full
        
        int key = item.getKey();
        int hashVal = hashFunc(key);
        
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1)
        {
            ++hashVal;      //go to next cell
            hashVal %= arraySize;   //wraparound if necessary
        }
        
        hashArray[hashVal] = item;    //insert item
    }
    
    public DataItem delete(int key) 
    {
        int hashVal = hashFunc(key);
        
        while(hashArray[hashVal] != null)
        {
            if (hashArray[hashVal].getKey() == key)
            {
                DataItem temp = hashArray[hashVal]; //save item
                hashArray[hashVal] = nonItem;       //deleteItem
                return temp;
            }
            
            ++hashVal;              //go to next cell
            hashVal %= arraySize;   //wraparound if necessary
        }
        
        return null;            //can't find item
    }
    
    public DataItem find(int key) 
    {
        int hashVal = hashFunc(key);
        
        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey() == key)
            {
                return hashArray[hashVal];
            }
            
            ++hashVal;              //go to next cell
            hashVal %= arraySize;   //wraparound if necessary
        }
        
        return null;        //can't find item
    }
}
