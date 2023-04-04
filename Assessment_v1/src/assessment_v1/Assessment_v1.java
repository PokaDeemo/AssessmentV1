/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment_v1;

/**
 *
 * @author Freeman
 */
public class Assessment_v1 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Encoder encoder = new Encoder('B');
       String encodedText = encoder.encode("HELLO WORLD");
       
       System.out.println("---- [Encoded_Text] ----");
       System.out.println(encodedText);
       
       String decodedText = encoder.decode(encodedText);
       System.out.println("---- [Decode_Text] ----");
       System.out.println(decodedText);
    }
    
}
