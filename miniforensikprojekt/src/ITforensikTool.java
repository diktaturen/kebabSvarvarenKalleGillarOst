/*
   Av Sebastian Ekman
*/

import java.util.*;
import java.io.*;

public class ITforensikTool
{  
   public static void main(String[] args)
   {
      Scanner tagent = new Scanner(System.in);

      boolean exiting = false;
      
      while(!exiting) {
         // Skriv ut alternativen
         System.out.println("Välj alternativ");
		 
         System.out.println("0. Avsluta");
         System.out.println("1. Lista katalog");
         System.out.println("2. Lista en typ av fil");
         System.out.println("3. Sok i filer");
         System.out.println("4. Konventera fil för sökning?");
         System.out.println("5. Sök modifierade filer efter datum");
         System.out.println("6. Kryptera/Dekryptera filer");
         
      
         // Läs in svar
         int svar = tagent.nextInt();
      
         // Beroende på svar, anropa respektive metod
         switch(svar) {
			 
		   case 0:
			      System.out.println("Avslutar..");
               exiting = true;
               break;
         case 1:
               System.out.println("Lista katalog");
               DirReader.main(args);               
               pressEnter();
               break;
         case 2:
               System.out.println("Lista en typ av fil");
               CallFindExtension.main(args);               
               pressEnter();
               break;
         case 3:
               System.out.println("Sok i filer");
               Findinfo.main(args);               
               pressEnter();
               break;
         case 4:
               System.out.println("Konventera fil för sökning");
               break;
         case 5:
               System.out.println("Sök modifierade filer efter datum");
               ByDate.listFiles();
               pressEnter();
               break;
         case 6:
               System.out.println("Kryptera/Dekryptera filer");
               Encryption.Kryptering();
               pressEnter();
               break;
         default:
               System.out.println("Felaktigt svar");
               break;
         }     
      }
      
      System.exit(1);  
   }
   
   public static void pressEnter(){
   
      System.out.println("Press Enter to continue...");
      Scanner scan = new Scanner(System.in);
      scan.nextLine();
   }
   
}