import java.io.File;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main { 
   public static void main(String[] args) { 
      listFilesByDate();
      //listFiles();
      
   }
   public static void listFilesByDate(){ //En funktion som ska lista filer eller mappar baserat
   // på senast modifierade.
      Scanner scamming = new Scanner(System.in);
      System.out.println("Print in the path (C:\\Users\\Karolina\\Documents\\whatever) to the directory you want to see the last modified files in. ");
      String input = scamming.nextLine();
      System.out.println("The output is going to be on the form DD-MM-YYYY. "); 
      File f1 = new File(input);
      // Metoden fungerar för att se på hela mappen eller enstaka filer, däremot inte om du 
      //har hela listor med input. Någon som har någon idé hur man kan få koden att lista 
      //alla filer som finns i listan? Jag har fastnat och får inte rätt på det...
      SimpleDateFormat sug = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      System.out.println("Last Modified: " + sug.format(f1.lastModified()));
      // Jag är lite smått obegåvad ja....
      }

   public static void listFiles(){ 
   // En funktion som listar alla filer inuti en given mapp.
      Scanner scamming = new Scanner(System.in);
      System.out.println("Print in the path (C:\\Users\\Karolina\\Documents\\whatever) to the directory you want to see the last modified files in. ");
      String input = scamming.nextLine(); 
      // Frågar användaren om vilken mapp som ska letas igenom och listas. 
      //Tanken är att man sedan ska kunna använda denna outputen till att söka efter dem 
      //senast ändrade filerna.
      File directory = new File(input);
      File[] flist = directory.listFiles();
      for (File file : flist){
         System.out.println(file.getName());
      }
   }
}

