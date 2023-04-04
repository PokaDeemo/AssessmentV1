/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment_v1;

import java.util.Arrays;

/**
 * @date 5/4/2023
 * @version 1.0
 * @author Tan Hong Rui Freeman
 */
public class Encoder 
{
    private char offset;
    
    public Encoder(char offset)
    {
        this.offset = offset;
    }
    
    public String encode(String plainText)
    {
        char[] Table = getTable(offset);
        StringBuilder encodedText = new StringBuilder();
        
        for(char c : plainText.toCharArray())
        {
            if(Arrays.binarySearch(Table, c) >= 0)
            {
                int index = Arrays.binarySearch(Table, c) + 1;
                encodedText.append(Table[index]);   
            }
            else 
            {
                encodedText.append(c);
            }
        }
        
        return encodedText.toString();   
    }
    
    public String decode(String encodedText)
    {
        char[] Table = getTable(offset);
        StringBuilder plainText = new StringBuilder();
        
        for(char c : encodedText.toCharArray())
        {
            if(Arrays.binarySearch(Table, c) >= 0)
            {
                int index = Arrays.binarySearch(Table, c) -1;
                plainText.append(Table[index]);
            }
            else 
            {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }
    
    private char[] getTable(char offset)
    {
         char[] Table = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
         int offsetIndex = Arrays.binarySearch(Table, offset);
         
         if(offsetIndex < 0)
         {
             return Table;
         }
         
         char[] newTable = new char[Table.length];
         
         for(int i = 0; i < Table.length; i++)
         {
             int newIndex = i + offsetIndex;
             
             if(newIndex >= Table.length)
             {
                 newIndex -= Table.length;
             }
             newTable[i] = Table[newIndex];
         }
         
         return newTable;
    }
}
