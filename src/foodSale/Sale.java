 package foodSale;

public class Sale {
	private Person person;
	private Food food;
	private int num;
	private int totalPrice;

	public Sale(Person person, Food food, int num)
	{
		this.person = person;
		this.food = food;
		this.num = num;
		totalPrice = food.getPrice() * num;
	}
	
	public Sale(Food food, int num, int totalPrice)
	{
		this.food = food;
		this.num = num;
		this.totalPrice = totalPrice;
	}
	
	public Sale(Person person, int num, int totalPrice)
	{
		this.person = person;
		this.num = num;
		this.totalPrice = totalPrice;
	}
	
	public Person getPerson()
	{
		return person;
	}
	
	public Food getFood()
	{
		return food;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public int getTotalPrice()
	{
		return totalPrice;
	}
	
	public void addNum(int num)
	{
		this.num += num;
	}
	
	public void addTotalPrice(int price)
	{
		this.totalPrice += price;
	}
	
	public String toString()
	{
		return person.getName() + ","+ food.getName() + "," + num;
	}
}
