import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * Write a description of class Gobbledegook here.
 * 
 * @James O'Shaughnessy 15187497 (your name) 
 * @version (3)
 */
public class Gobbledegook3
{
    private static ArrayList<String> ex;
    private LinkedList<String> dictionary ;
    private LinkedList<String> email ;
    private static LinkedList<wordCount2> words;
    private ArrayList<String> ewords;
    public LinkedList<String> users;
    String line;
    String name;
    String text;
    String con=" ";
    String temp="";
    
    
      

    public  Gobbledegook3(){
        
        ex = new ArrayList<String>( Arrays.asList( "gpostbegin","gpostend","a","this", "that"," ","these",
                                                           "those", "he", "you", 
                                                           "them","us","it","is",
                                                           "on", "off", "up",
                                                           "down", "but", "to",
                                                           "a", "about", "after", "all", 
                                                           "also", "an", "another", "any", 
                                                           "are", "as", "and", "at", "i", 
                                                           "each", "even",
                                                            "for", "from", "further", "furthermore",
                                                            "get", "got",
                                                            "has", "had", "he", "have", "her", "here", "him", 
                                                            "himself", "his", "how", "hi", "however",
                                                            "i", "if", "in", "into", "is", "it", "its", "indeed",
                                                            "just",
                                                            "like",
                                                            "made", "many", "me", "might", "more", "moreover",
                                                            "most", "much", "must", "my",
                                                            "never", "not", "now",
                                                            "of", "on", "only", "other", "our", "out", "or", "over",
                                                            "said", "same", "see", "should", "since", "she",
                                                            "some", "still", "such",
                                                            "take", "than", "that", "the", "their", "them", 
                                                            "then", "there", "these", "therefore", "they", 
                                                            "this", "those", "through", "to", "too", "thus",
                                                            "under", "up",
                                                            "very",
                                                            "was", "way", "we", "well", "were", "what", "when", "where",
                                                            "which", "while", "who", "will", "with", "would",
                                                            "you", "your"
                                                            ));
                                                           
       words = new LinkedList<wordCount2>(); 
       long time = System.currentTimeMillis() ; 
       dictionary = loadWordsFromFile() ;
       System.out.println("Reading File from Java code"); 
       
       time = System.currentTimeMillis()-time ;                        
       //System.out.println(words.toString());
       System.out.println("File Read Successfully, time taken: "+time+" milliseconds.");
       // }
       //Name of the file
       //String fileName="wlist_match10.txt";
    }

        private LinkedList<String> loadWordsFromFile()     {
        
       
         try{
    
              //Create object of FileReader
              
              FileReader inputFile = new FileReader("gPostMessages.txt");
    
              //Instantiate the BufferedReader Class
              BufferedReader bufferReader = new BufferedReader(inputFile);
    
              //Variable to hold the one line data
              String line;
              String name="";
              String text;
              String word;
              String temp;
              int o =0;
              
    
              // Read file line by line and print on the console
              while ((line = bufferReader.readLine()) != null)   {
               
                       
                       word = line;
                  
                       String alpha="";
                 
    
                   for(int x =0; x<word.length();x++){
                       
                       if(Character.isLetter(word.charAt(x))|| (word.charAt(x)==' ') ||(word.charAt(x)=='@')){
                         //if(!(word.substring(x,x+1)).contains(" ")){
                           alpha += word.substring(x,x+1);
                        //}
                    }
                }
                ArrayList<wordCount2> artistTracks = new ArrayList<wordCount2>();
                alpha=alpha.replaceAll("\\s{2,}", " ");
                alpha=(alpha.toLowerCase());
                //System.out.println(alpha);
                int b=0;//just used for a condition
                
                     for (String t: alpha.split(" ")){
                            //t=(t.toLowerCase());
                            //System.out.println(t);

                             if(!ex.contains(t)){
                                        if(t.contains("@")){
                                            name=t.substring(0,t.indexOf("@"));
                                            //name=line.substring(0,line.indexOf("@"));
                                        }
                                        else{
                                              //ArrayList<wordCount2> artistTracks = new ArrayList<wordCount2>();
                                              //searches through the list to find duplicates
                                                for(wordCount2 k : words) {
                                                        if(k.getname().equals(name)&&(k.getword().equals(t))){
                                                        //if(k.getword().equals(t)) {
                                                            // increase the wordcount
                                                           k.setcount(k.getcount()+1);
                                                            
                                                            b++;
                                                        //}
                                                    }
                                                    
    
                                                  
                                               } 
                                               if(b==0){    
                                                    words.add(new wordCount2(1,name,t));
                                                    
                                               }   
                                            b=0;
                                    }
                                    
                                        
                           }
                        }
                       }
                       
                           
                         words.remove(0);  
                            
                  //Close the buffer reader
                  bufferReader.close();
               }
            
               catch(Exception e){
                  System.out.println("Error while reading file line by line:" + e.getMessage());                      
               }
               return users;
           
        
               
    }
    public void displayUser(String artist) {
        ArrayList<wordCount2> artistTracks = new ArrayList<wordCount2>();
        for(wordCount2 t : words) {
            if(t.getname().equalsIgnoreCase(artist)) {              
                artistTracks.add(t);               
            }
        }
         //System.out.println(artistTracks.toString());
         //Collections.sort(artistTracks);
         Collections.sort(artistTracks, new Comparator<wordCount2>() {
                    public int compare(wordCount2 x, wordCount2 y) {
                        return Integer.compare(y.getcount(),x.getcount());
                    }
        });
        
        System.out.println(artistTracks.toString());
    }

    
    public void displayAll() {
        ArrayList<wordCount2> artistTracks = new ArrayList<wordCount2>();
        ArrayList<String> top = new ArrayList<String>();
        name = "test";
        for(wordCount2 t : words) {
            
                
                //stores the name of the users for processing
                if(!name.equals(t.getname())){
                    name = t.getname();
                    top.add(name);
                }
               
            
        }
        Collections.sort(top);
        //calls the function for each name stored in top and displays the result
        for(int k=0;k<top.size();k++){
            System.out.println("E-Mail Address: "+top.get(k)+"@gPost.com");
            
            displayUser(top.get(k));
        }
        
    }
    
    
        }
      
