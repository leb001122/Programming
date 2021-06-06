import java.util.Scanner;

public class AddressBookApp {
    public static void main(String[] args) {

        AddressBookUserIO userIO = new AddressBookUserIO();
        AddressBookFileIO fileIO = new AddressBookFileIO();
        AddressBook address = new AddressBook();

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("1. Input Person 2. Delete Person 3. Print All 4. Sava File 5. Exit ? ");
            int menu = sc.nextInt();
            sc.nextLine();
            if(menu == 5)
                break;
            userIO.handleMenu(menu, sc, address, fileIO);
        }
        sc.close();
    }
}
