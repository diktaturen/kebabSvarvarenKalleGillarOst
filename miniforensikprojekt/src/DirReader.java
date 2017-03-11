import java.util.Scanner;
import java.io.File;


/**
 * Created by poff on 2017-02-28.
 */
 
public class DirReader {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); 

        System.out.println("Mata in abs-Path"); //be om indata
        String inPath = input.next(); //hämta indata
        walk(inPath); //påkalla walk-metoden som vandrar genom directoryn man valt

    }

   public static void walk(String path) {

        File startPath = new File(path); 
        File[] list = startPath.listFiles(); //skapar en File-array utav alla items i directoryn man matat in

        if (list == null) return; //om listan är tom händer ingenting.

        for (File f : list) { //start av for-loop som kollar varje item i arrayen
            if (f.isDirectory()) { //if-sats om itemet är ett directory 
                walk(f.getAbsolutePath()); //så påkallas walk-metoden på directoryt
                System.out.println("Dir:" + f.getAbsoluteFile()); //printar absolutpathen för directoryn
            } else { //om itemet inte är ett directory så är det en fil och printar då absolut-pathen till filen
                System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }


}
