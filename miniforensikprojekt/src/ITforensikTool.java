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
         System.out.println("V�lj alternativ");
		 
         System.out.println("0. Avsluta");
         System.out.println("1. Lista katalog");
         System.out.println("2. Lista en typ av fil");
         System.out.println("3. Sok i filer");
         System.out.println("4. Konventera fil f�r s�kning?");
         System.out.println("5. S�k modifierade filer efter datum");
         System.out.println("6. Kryptera/Dekryptera filer");
         
      
         // L�s in svar
         int svar = tagent.nextInt();
      
         // Beroende p� svar, anropa respektive metod
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
               System.out.println("Konventera fil f�r s�kning");
               break;
         case 5:
               System.out.println("S�k modifierade filer efter datum");
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