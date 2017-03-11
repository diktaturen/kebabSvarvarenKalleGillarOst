package SmallProject;

import java.io.*;
import java.util.Scanner;

/**
 * Created by limE on 2017-03-07.
 */
public class Encryption
{
    public void Kryptering(){
        //variabler
        String path, spara, klar = "", rng;
        int count = 0, val;

        //scanner
        Scanner in = new Scanner(System.in);

        //fråga om man vill kryptera eller dekryptrera
        System.out.println("Vad vill du göra?\n" +
                "0. Avsluta\n" +
                "1. Kryptera\n" +
                "2. Dekryptera\n");

        val = in.nextInt();
        in.nextLine();

        //fråga användaren vilken fil
        System.out.println("Mata in Abs-path (inkl filsorten).");
        path = in.nextLine();

        System.out.println("Vart vill du spara den kryptreade/dekrypterade filen? (hela namnet inkl filsort)");
        spara = in.nextLine();

        //skapa två nya filvägar så den vet vart den ska leta.
        File file = new File(path);
        File create = new File(spara);

        switch(val){
            case 0:
                System.out.println("Avslutar...");
                break;

            case 1:
                print(file, create, klar, count, val);

                break;

            case 2:
                print(file, create, klar, count, val);

                break;

            default:
                System.out.println("Felaktigt alternativ!");
        }
    }

    public String encrypt(String text, String klar_text) {

        for(int i = 0; i < text.length(); i ++){

            int ascii_ny = (int)text.charAt( i ) + 1;

            klar_text = klar_text + ((char)ascii_ny);
        }
        return klar_text;
    }

    public String decrypt(String text, String klar_text) {

        for(int i = 0; i < text.length(); i ++){

            int ascii_ny = (int)text.charAt( i ) - 1;

            klar_text = klar_text + ((char)ascii_ny);
        }
        return klar_text;
    }

    public void print(File file, File create, String klar, int count, int val){
        try{
            Scanner filescan = new Scanner(file);
            String text;

            while(filescan.hasNext()) {

                text = filescan.nextLine();

                //anropa metod beroende på vad du vill göra
                if(val == 1){
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
                if(val == 2){
                    String done = decrypt(text, klar);

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

            }

        } catch(Exception e) {System.out.println(e);
            count++;}

        if(count < 1){
            System.out.println("Klar!");
        }
    }
}

