package old.java8.chapter1;

import java.io.File;

/**
 * Created by Administrator on 2018/02/23.
 */
public class FunAndLambda {

    public static void main(String[] args) {
//        File[] hiddenFiles = new File("C:/").listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File f) {
//                return f.isHidden();
//            }
//        });

//        File[] hiddenFiles = new File("C:/").listFiles(File::isHidden);
//        File[] hiddenFiles = new File("C:/").listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.endsWith("s");
//            }
//        });

        File[] hiddenFiles = new File("C:/").listFiles((dir,name)->{
            return name.endsWith("s");
        });

        for (File hiddenFile : hiddenFiles) {
            System.out.println(hiddenFile.getAbsolutePath());
        }
    }
}
