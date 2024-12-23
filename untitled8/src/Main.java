import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("FileTest");
        PrintWriter pw = new PrintWriter(file);
        pw.println("TEEEEEEEEEEEST row 1");
        pw.println("TEST ROW 2");
        pw.close();
    }
}