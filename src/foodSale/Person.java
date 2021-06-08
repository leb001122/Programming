package foodSale;

public class Person {
	private String name;
	private String phoneNum;

	public Person(String name, String phoneNum)
	{
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhoneNum()
	{
		return phoneNum;
	}
	
	public String toString()
	{
		return name + ", " + phoneNum;
	}
}
