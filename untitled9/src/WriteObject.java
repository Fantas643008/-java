import java.io.*;

public class WriteObject {
    public static void main(String[] args) throws IOException {

        Person[] people = {new Person(1,"Danila"),new Person(2,"Pleg"), new Person(3,"Nastya")};

        FileOutputStream fileOutputStream = new FileOutputStream("PeopleSave.bin");
        ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
        objectInputStream.writeObject(people);


        fileOutputStream.close();


    }
}
