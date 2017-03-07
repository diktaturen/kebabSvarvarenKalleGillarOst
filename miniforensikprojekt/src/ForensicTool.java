//import static org.apache.commons.io.comparator.LastModifiedFileComparator.*;
import java.io.Arrays;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
public class ForensicTool{
   public static void main (String [] args){
      FindFiles();
   }
   
   public static void FindFiles(){
      File folder = new File("/home/documents/programmering/forensic_tool");
      File[] files = folder.listFiles();
      Arrays.sort(files);
        //Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
        for (File file : files) {
            Date lastMod = new Date(file.lastModified());
            System.out.println("File: " + file.getName() + ", Date: " + lastMod + "");
        }
         }
}