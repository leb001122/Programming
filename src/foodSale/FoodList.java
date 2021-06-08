package foodSale;

public class FoodList {
	private Food [] foodArr;
	private int size;
	
	public FoodList()
	{
		size = 0;
		foodArr = new Food[100];
	}
	
	public Food getFood(String name)
	{
		for(int i = 0; i < size; i++)
		{
			if(foodArr[i].getName().equals(name))
				return foodArr[i];
		}
		return null;
	}
	
	public int search(String name)
	{
		for(int i = 0; i < size; i++)
		{
			if(foodArr[i].getName().equals(name))
				return i;
		}
		return -1;
	}
	
	public int add(Food newFood)
	{			
		if(search(newFood.getName()) >= 0) // 이미 존재하는 음식
			return 0;
		
		foodArr[size] = newFood;
		size++;
		return 1;
	}
	
	public int delete(String name)
	{
		int idx = search(name);
		
		if(idx < 0) // 존재하지 않는 음식
			return 0;
		
		foodArr[idx] = foodArr[size-1];
		foodArr[size-1] = null;
		size--;
		return 1;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++)
		{
			sb.append(foodArr[i] + "\n");
		}
		return sb.toString();
	}
	
	public void printFList()
	{
		for(int i = 0; i < size; i++)
			System.out.println("> " + foodArr[i]);
	}
}













