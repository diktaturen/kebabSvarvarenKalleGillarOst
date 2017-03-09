/*
	Av Sebastian Ekman
*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Findinfo
{
   public static void main(String[] args)
   {
      Scanner tagent = new Scanner(System.in);
           
      System.out.println("Vart vill du soka? (absolut sokvag)");
      String sokvag = tagent.next();
      
      File path = new File(sokvag);
      File[] filer = path.listFiles();
      
      System.out.println("Ange sokord");
      String sokord = tagent.next();
      
      System.out.println("I vilken typ av fil?");
      String datatyp = tagent.next();
      
      File[] filerMedSokord = findIn(sokord,filer,datatyp);      
      
   
   }

   public static File[] findIn(String sok, File[] filer, String filtyp)
   {
      //Skapa en ArrayList för vi vet inte hur stor array'n behöver vara
      ArrayList<File> reFiles = new ArrayList<File>();
      
      System.out.println("Filtyp angivet: "+filtyp);
      try {            
            
            int antal=0;
            
            // Loopa igenom alla filer i filer listan
            for(int i=0; i<filer.length; i++) {   
            
               // Kontrollera om den är av önskade filtypen
               String nm = filer[i].getName(); 

               if(filtyp.equals(nm.substring(nm.length()-3,nm.length())))  {
               
                     // Skapa ett scanner objekt för att läsa varje fil
                    Scanner fil = new Scanner(filer[i]);              
                     
                    // Medans filen har en rad att läsa..
                    while(fil.hasNext()) {
                       
                      // Om raden vi läser från filen innehåler sökordet..
                      if(fil.next().contains(sok)) {                        
                        System.out.println("Sokord funnits i fil: "+filer[i].getPath());
                        reFiles.add(filer[i]); // Lägg till objektet i ArrayListan
                        antal++;
                     }
                  }  
               }            
            }
               System.out.println("Antal gonger ordet forekommit: "+antal);               
                  
            } catch (Exception e) { 
               System.out.println("Ett fel uppstod: " +e);
            }
            
            // Konventera ArrayListan till en vanlig Array att returnera
            File[] arrayFiles = reFiles.toArray(new File[0]);
            
            return arrayFiles;       
      
   }
}