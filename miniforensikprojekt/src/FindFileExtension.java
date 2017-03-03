package SmallProject;

import java.io.*;
import java.util.Scanner;

public class FindFileExtension {
    public void FindExtension(){

        //variabler
        String Drive, Extension;

        //scanner
        Scanner in = new Scanner(System.in);

        //fråga & spara information
        System.out.println("Vilken hårddisk vill du kolla igenom? Skriv Hårddiskens siffra. Ex: C");

        Drive = in.nextLine();

        System.out.println("Vad för slags fil letar du efter? Skriv filens typ. Ex: txt");

        Extension = in.nextLine();

        //Anropa metod
        extract( Drive + ":\\", Extension);
    }

    public void extract(String p, String e){

        //Skapa en ny fil
        File f=new File(p);
        //Array som allt läggs i
        File l[]=f.listFiles();

        for(File x:l)
        {
            //retunera om x det inte hittar mer
            if(x==null){return;}
            //hoppar gömnda filer och filer som inte går att läsa
            if(x.isHidden()||!x.canRead())
                continue;
            //börja om om det finns mer directories och subdirectories
            if(x.isDirectory())
                extract(x.getPath(), e);
            //prina ut filepathen samt namnet.
            else if(x.getName().endsWith(e))
                System.out.println(x.getPath()+"\\"+x.getName());
        }

    }

}
