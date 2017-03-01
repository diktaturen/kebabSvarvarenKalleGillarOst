/**
 * Created by poff on 2017-02-28.
 */

import java.io.File;

public class FileWalker {

    public void walk(String path) {

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