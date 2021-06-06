import java.util.Scanner;

public class AddressBookUserIO {

    public void handleMenu(int menu, Scanner sc, AddressBook address, AddressBookFileIO fileIO) {
        if(menu == 1) {
            inputPerson(sc, address);
        }
        else if(menu == 2) {
            deletePerson(sc, address);
        }
        else if(menu == 3) {
            printAll(address);
        }
        else if(menu == 4) {
            saveFile(sc, address, fileIO);
        }
        else {
            System.out.println("Enter the correct menu number.");
        }
    }

    public void inputPerson(Scanner sc, AddressBook address)
    {
        try {
            System.out.print("Input Person ? ");
            String line = sc.nextLine();
            line = line.trim();
            String []str = line.split(",");
            address.inputPerson(new Person(Integer.parseInt(str[0]),str[1],str[2],str[3],str[4]));
            System.out.println("> OK");

        } catch (DuplicatedPersonIdException e) {
            System.out.println("> Error, ID 충돌");
        }
    }

    public void deletePerson(Scanner sc, AddressBook address) {
        try {
            System.out.print("Input ID ? ");
            address.deletePerson(sc.nextInt());
            System.out.println("> OK");

        } catch (NoSuchPersonIdException e) {
            System.out.println("> Error, 사람없음");
        }
    }

    public void printAll(AddressBook address)
    {
        System.out.println(address.toStirng());
    }

    public void saveFile(Scanner sc, AddressBook address, AddressBookFileIO fileIO)
    {
        System.out.print("FileName ? ");
        fileIO.saveFile(address, sc.nextLine());
    }
}
