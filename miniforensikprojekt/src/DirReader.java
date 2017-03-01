import java.util.Scanner;

/**
 * Created by poff on 2017-02-28.
 */
public class DirReader {
    public static void main(String[] args) {

        FileWalker fw = new FileWalker();
        Scanner input = new Scanner(System.in);

        System.out.println("Mata in abs-Path");
        String inPath = input.next();
        fw.walk(inPath);

    }

}
