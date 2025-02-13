import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("PeopleSave.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person[]  person  = (Person[]) objectInputStream.readObject();

        System.out.println(Arrays.toString(person));
        fileInputStream.close();

    }
}
