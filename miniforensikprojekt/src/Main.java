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
   // p� senast modifierade.
      Scanner scamming = new Scanner(System.in);
      System.out.println("Print in the path (C:\\Users\\Karolina\\Documents\\whatever) to the directory you want to see the last modified files in. ");
      String input = scamming.nextLine();
      System.out.println("The output is going to be on the form DD-MM-YYYY. "); 
      File f1 = new File(input);
      // Metoden fungerar f�r att se p� hela mappen eller enstaka filer, d�remot inte om du 
      //har hela listor med input. N�gon som har n�gon id� hur man kan f� koden att lista 
      //alla filer som finns i listan? Jag har fastnat och f�r inte r�tt p� det...
      SimpleDateFormat sug = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      System.out.println("Last Modified: " + sug.format(f1.lastModified()));
      // Jag �r lite sm�tt obeg�vad ja....
      }

   public static void listFiles(){ 
   // En funktion som listar alla filer inuti en given mapp.
      Scanner scamming = new Scanner(System.in);
      System.out.println("Print in the path (C:\\Users\\Karolina\\Documents\\whatever) to the directory you want to see the last modified files in. ");
      String input = scamming.nextLine(); 
      // Fr�gar anv�ndaren om vilken mapp som ska letas igenom och listas. 
      //Tanken �r att man sedan ska kunna anv�nda denna outputen till att s�ka efter dem 
      //senast �ndrade filerna.
      File directory = new File(input);
      File[] flist = directory.listFiles();
      for (File file : flist){
         System.out.println(file.getName());
      }
   }
}

