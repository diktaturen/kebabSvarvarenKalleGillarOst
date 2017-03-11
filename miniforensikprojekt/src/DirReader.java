import java.util.Scanner;
import java.io.File;


/**
 * Created by poff on 2017-02-28.
 */
 
public class DirReader {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); 

        System.out.println("Mata in abs-Path"); //be om indata
        String inPath = input.next(); //h�mta indata
        walk(inPath); //p�kalla walk-metoden som vandrar genom directoryn man valt

    }

   public static void walk(String path) {

        File startPath = new File(path); 
        File[] list = startPath.listFiles(); //skapar en File-array utav alla items i directoryn man matat in

        if (list == null) return; //om listan �r tom h�nder ingenting.

        for (File f : list) { //start av for-loop som kollar varje item i arrayen
            if (f.isDirectory()) { //if-sats om itemet �r ett directory 
                walk(f.getAbsolutePath()); //s� p�kallas walk-metoden p� directoryt
                System.out.println("Dir:" + f.getAbsoluteFile()); //printar absolutpathen f�r directoryn
            } else { //om itemet inte �r ett directory s� �r det en fil och printar d� absolut-pathen till filen
                System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }


}
