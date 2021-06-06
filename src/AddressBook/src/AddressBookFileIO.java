import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBookFileIO {

    public AddressBookFileIO() {}

    public void saveFile(AddressBook address, String filename)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(String.valueOf(address.toStirng()));
            bw.close();
            System.out.println("> OK");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
