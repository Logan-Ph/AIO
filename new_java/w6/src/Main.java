import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[]args)
    {
        File curDir = new File(".");
        getAllFiles(curDir);
    }
    private static void getAllFiles(File curDir) {
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory()) {
                System.out.printf("<%s>%n", f.getName());
                getAllFiles(f);
            }
            if(f.isFile()){
                System.out.println("    "+f.getName());
            }
        }
    }
}