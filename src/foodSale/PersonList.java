package foodSale;

public class PersonList {
	private Person [] personArr; 
	private int size;
	
	public PersonList()
	{
		size = 0;
		personArr = new Person[100];
	}
	
	public int search(String name)
	{
		for(int i = 0; i < size; i++)
		{
			if(personArr[i].getName().equals(name))
				return i;
		}
		return -1;
	}
	
	public int add(Person newPerson)
	{
		if(search(newPerson.getName()) >= 0) // 이미 존재하는 사람
			return 0;
		
		personArr[size] = newPerson;
		size++;
		return 1;
	}
	
	public int delete(String name)
	{
		int idx = search(name);
		
		if(idx < 0) // 존재하지 않는 사람
			return 0;
		
		personArr[idx] = personArr[size-1];
		personArr[size-1] = null;
		size--;
		return 1;
	}
	
	public Person getPerson(String name)
	{
		for(int i = 0; i < size; i++)
		{
			if(personArr[i].getName().equals(name))
				return personArr[i];
		}
		return null;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++)
		{
			sb.append(personArr[i] + "\n");
		}
		return sb.toString();
	}
	
	public void printPList()
	{
		for(int i = 0; i < size; i++)
			System.out.println("> " + personArr[i]);
	}
	
}
