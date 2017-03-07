import java.util.Scanner;
import java.io.File;


/**
 * Created by poff on 2017-02-28.
 */
public class DirReader {
    public static void main(String[] args) {

        FileWalker fw = new FileWalker();
        Scanner input = new Scanner(System.in);

        System.out.println("Mata in abs-Path");
        String inPath = input.next();
        walk(inPath);

    }

   public static void walk(String path) {

        File startPath = new File(path);
        File[] list = startPath.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath());
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }


}
