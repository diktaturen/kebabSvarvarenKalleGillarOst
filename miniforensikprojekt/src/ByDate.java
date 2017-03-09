import java.util.*;
import java.io.File;
import java.text.SimpleDateFormat;


public class ByDate { 

   public static void listFiles(){ //En funktion som ska lista filer eller mappar baserat
         // p� senast modifierade.
         Scanner scamming = new Scanner(System.in);
         System.out.println("Print in the path (C:\\Users\\Karolina\\Documents\\whatever) to the directory you want to see the last modified files in. ");
         String input = scamming.nextLine();
         System.out.println("The output is going to be on the form DD-MM-YYYY. "); 
         File f1 = new File(input);
   
         // Skapa SimpleDateFormat objekt
         SimpleDateFormat sug = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
 
         File[] files = f1.listFiles(); // Skapa en array med alla filer i

         File tmp;
         boolean harByttPlats = true;
         
         // While loopen k�rs s� l�nge �ndring har gjorts i array'n. N�r inga objekt har bytt plats
         // s� stannar harByttPlats p� false och while loopen avslutar
         while(harByttPlats) {
         
            harByttPlats = false;
         
            for (int i=0; i<files.length; i++){
               if((i+1) < files.length) {
               
                  //System.out.println("Kontrollerar "+files[i].lastModified()+" > "+files[i+1].lastModified());
                  
                  // Teorin �r att j�mnf�ra nuvarande Timestamp med Timpestampen som n�sta fil har
                  // och om den �r mindre, byt plats. G�r om detta tills inga �ndringar beh�vs g�ras                  
                  
                  if(files[i].lastModified() > files[i+1].lastModified()) {
                     //Byt plats
                     tmp = files[i];
                     files[i] = files[i+1];
                     files[i+1] = tmp;
                     
                     harByttPlats = true;
                     //System.out.println("bytte :"+files[i].getName()+"<->"+files[i+1].getName());
                  }        
               }
               
            }
         } 

                 
         // Lista alla filer i ordning
         for (File fil : files){
            System.out.println(fil.getName()+" "+sug.format(fil.lastModified()));
         }       
      }
}

