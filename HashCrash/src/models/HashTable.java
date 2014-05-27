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
    
    private final DataItem[] hashArray;
    private final int arraySize;
    private final DataItem nonItem;   //for deleted items
    
    public HashTable(int size)  //contstructor
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(null);     //deleted item key is -1
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
     * taken from page 565 in the book
     * @param key
     * @return 
     */
    public int hashFunc3(String key)
    {
        int hashVal = 0;
        
        for (int j = 0; j < key.length(); j++)
        {
            int letter = key.charAt(j) - 96;    //get char code
            hashVal = (hashVal * 27 + letter) % arraySize;
        }
        
        return hashVal;
    }
    
    /**
     * NOTE: assumes table is not full
     * @param item 
     */
    public void insert(DataItem item)
    {
        //assumes table not full
        
        String key = item.getKey();
        int hashVal = hashFunc3(key);
        
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != null)
        {
            ++hashVal;      //go to next cell
            hashVal %= arraySize;   //wraparound if necessary
        }
        
        hashArray[hashVal] = item;    //insert item
    }
    
    public DataItem delete(String key) 
    {
        int hashVal = hashFunc3(key);
        
        while(hashArray[hashVal] != null)
        {
            if (hashArray[hashVal].getKey().equals(key))
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
    
    public DataItem find(String key) 
    {
        int hashVal = hashFunc3(key);
        
        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey().equals(key))
            {
                return hashArray[hashVal];
            }
            
            ++hashVal;              //go to next cell
            hashVal %= arraySize;   //wraparound if necessary
        }
        
        return null;        //can't find item
    }
}
