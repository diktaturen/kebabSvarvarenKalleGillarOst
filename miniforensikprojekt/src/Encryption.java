
import java.io.*;
import java.util.Scanner;

/**
 * Created by limE on 2017-03-07.
 */
public class Encryption
{
    public void Kryptering(){
        //variabler
        String text, path, spara, klar = "";;
        int count = 0;

        //scanner
        Scanner in = new Scanner(System.in);

        //fråga användaren vilken fil
        System.out.println("Mata in Abs-path inkl filsorten");
        path = in.nextLine();

        System.out.println("Vart vill du spara den kryptreade filen, hela namned inkl filsort");
        spara = in.nextLine();

        File file = new File(path);
        File create = new File(spara);
        create.getParentFile().mkdirs();

        try{
            Scanner filescan = new Scanner(file);

            while(filescan.hasNext()) {

                text = filescan.nextLine();

                //anropa metod jävel
                String done = encrypt(text, klar);

                try {
                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(create, true)));

                    writer.println(done);
                    writer.flush();
                    writer.close();

                } catch (IOException e) {

                    System.out.println(e);
                    count++;
                }

            }

        } catch(Exception e) {System.out.println(e);
        count++;}

        if(count < 1){
            System.out.println("Klar!");
        }

    }
    public String encrypt(String text, String klar_text) {

        for(int i = 0; i < text.length(); i ++){

            int ascii_ny = (int)text.charAt( i ) + 1;

            klar_text = klar_text + ((char)ascii_ny);
        }
        return klar_text;
    }
}

