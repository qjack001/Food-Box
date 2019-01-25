import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Read/Write Helper
 *
 *  Simple utility class to read and write from file.
 *  Specifically designed to be used with the Alarm object.
 *
 *  @author Jack Guinane
 *  @version 1.0
 *  @created 2015-10-22
 */

public class ReadWrite
{
    /**
     *  Reads and returns the contents of a file 
     *  in the form of a String
     *
     *  @param String fileName (the name/directory of the file)
     *  @return String (the contents of the file)
     */
    public static ArrayList<String> read(String fileName) 
    {
        ArrayList<String> output = new ArrayList<String>(); //the outputed text
        String line = null;  //the line of text being read in

        try 
        {
            FileReader fileReader = new FileReader(fileName); 
            BufferedReader bufferedReader = new BufferedReader(fileReader); 
             
            /*
             *  reads the text file
             *  continues while the current line is not null (i.e. end of document)
             */                                                               
            while((line = bufferedReader.readLine()) != null) 
            {
                 output.add(line); //adds line to output
            }    

            bufferedReader.close(); //closes file
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file \"" + fileName + "\"");
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file \"" + fileName + "\"");
        }
        
        return output; 
    }
    
    public static void write(ArrayList<Alarm> textIn, String path)
    {
        try
        {
            String text = "";
            
            if(textIn.size() > 0)
                text = textIn.get(0).getAscii();
            
            for(int i = 1; i < textIn.size(); i++)
            {
                text += "\n" + textIn.get(i).getAscii();
            }
            
            FileWriter writer = new FileWriter(path,false); 
            PrintWriter printer = new PrintWriter(writer); //wraps in PrintWriter
            printer.println(text); 
            printer.close(); //closes file
        }
        catch(IOException ex) //if there is an error writing file (required)
        {
            System.out.println("Error writing file"); //print error message
        }
    }
    
    public static void write(String text, String path)
    {
        try
        {
            FileWriter writer = new FileWriter(path,false); 
            PrintWriter printer = new PrintWriter(writer); //wraps in PrintWriter
            printer.println(text); 
            printer.close(); //closes file
        }
        catch(IOException ex) //if there is an error writing file (required)
        {
            System.out.println("Error writing file"); //print error message
        }
    }
}