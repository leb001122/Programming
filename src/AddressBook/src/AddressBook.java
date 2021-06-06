public class AddressBook {

    private static final int INIT_SIZE = 5;
    private Person address[];
    private int count;

    public AddressBook() {
        this(INIT_SIZE);
    }

    public AddressBook(int size) {
        address = new Person[size];
        count = 0;
    }

    public int search(int id)
    {
        if(isEmpty())
            return -1;

        for(int i=0; i<count; i++)
        {
            if(address[i].getId() == id)
                return i;
        }
        return -1;
    }

    public void inputPerson(Person newPerson)
    {
        if(search(newPerson.getId()) >= 0)
            throw new DuplicatedPersonIdException();

        if(count == address.length)
            resize(address.length * 2);
        address[count] = newPerson;
        count++;
    }

    public void deletePerson(int id)
    {
        int idx = search(id);
        if(idx == -1)
            throw new NoSuchPersonIdException();
        else
        {
            for(int i=idx; i<count-1; i++)
            {
                address[i] = address[i+1];
            }
            address[count] = null;
            count--;
        }

    }

    public int getCount()
    {
        return count;
    }

    public void resize(int newSize)
    {
        Person [] temp = new Person[newSize];
        for(int i=0; i<count+1; i++)
            temp[i] = address[i];
        address = temp;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public String toStirng() {
        String str = "";

        if(isEmpty())
            return "> 주소록이 비어있음";

        for(int i=0; i<count-1; i++) {
            str += address[i].toStirng()+"\n";
        }
        str += address[count-1].toStirng();
        return str;
    }
}

class DuplicatedPersonIdException extends RuntimeException {
}

class NoSuchPersonIdException extends  RuntimeException {
}