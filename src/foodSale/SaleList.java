package foodSale;

public class SaleList {
	private Sale [] saleArr;
	private int size;
	
	public SaleList()
	{
		size = 0;
		saleArr = new Sale[100];
	}
	
	public void add(Sale newSale)
	{
		saleArr[size] = newSale;
		size++;
	}
	
	public void food_saleStatistics() // 음식별 판매 통계
	{
		Sale [] tmpArr = new Sale[100];
		int tmpSize = 0;
		
		Outer : 
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < tmpSize; j++)
			{
				if(saleArr[i].getFood().getName().equals(tmpArr[j].getFood().getName()))
				{
					tmpArr[j].addNum(saleArr[i].getNum());
					tmpArr[j].addTotalPrice(saleArr[i].getNum() * saleArr[i].getFood().getPrice());
					continue Outer;
				}
				
			}
			tmpArr[tmpSize] = new Sale(saleArr[i].getFood(), saleArr[i].getNum(), saleArr[i].getTotalPrice());
			tmpSize++;
		}
		
		for(int i = 0; i < tmpSize; i++)
		{
			System.out.printf("> %s, %d개, %d원\n", tmpArr[i].getFood().getName(), tmpArr[i].getNum(), tmpArr[i].getTotalPrice());
		}
	}
	
	public void person_saleStatistics() // 사람별 판매 통계
	{
		Sale [] tmpArr = new Sale[100];
		int tmpSize = 0;
		
		Outer : 
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < tmpSize; j++)
			{
				if(saleArr[i].getPerson().getName().equals(tmpArr[j].getPerson().getName()))
				{
					tmpArr[j].addNum(saleArr[i].getNum());
					tmpArr[j].addTotalPrice(saleArr[i].getNum() * saleArr[i].getFood().getPrice());
					continue Outer;
				}
				
			}
			tmpArr[tmpSize] = new Sale(saleArr[i].getPerson(), saleArr[i].getNum(), saleArr[i].getTotalPrice());
			tmpSize++;
		}
		
		int totalNum = 0;
		int totalPrice = 0;
		for(int i = 0; i < tmpSize; i++)
		{
			int num = tmpArr[i].getNum();
			int price = tmpArr[i].getTotalPrice();
			System.out.printf("> %s, %d개, %d원\n", tmpArr[i].getPerson().getName(), num, price);
			totalNum += num;
			totalPrice += price;
		}
		System.out.printf("- Total %d개, %d원 -\n", totalNum, totalPrice);
		
	}
	
	public void person_purchaseStatistics(String pName) // 사람별 구매 통계
	{
		Sale [] tmpArr = new Sale[100];
		int tmpSize = 0;
		
		Outer : 
		for(int i = 0; i < size; i++)
		{
			if(!saleArr[i].getPerson().getName().equals(pName))
				continue;
			for(int j = 0; j < tmpSize; j++)
			{
				if(saleArr[i].getFood().getName().equals(tmpArr[j].getFood().getName()))
				{
					tmpArr[j].addNum(saleArr[i].getNum());
					tmpArr[j].addTotalPrice(saleArr[i].getNum() * saleArr[i].getFood().getPrice());
					continue Outer;
				}
				
			}
			tmpArr[tmpSize] = new Sale(saleArr[i].getFood(), saleArr[i].getNum(), saleArr[i].getTotalPrice());
			tmpSize++;
		}
		
		int totalNum = 0;
		int totalPrice = 0;
		for(int i = 0; i < tmpSize; i++)
		{
			int num = tmpArr[i].getNum();
			int price = tmpArr[i].getTotalPrice();
			System.out.printf("> %s, %d개, %d원\n", tmpArr[i].getFood().getName(), num, price);
			totalNum += num;
			totalPrice += price;
		}
		System.out.printf("- Total %d개, %d원 -\n", totalNum, totalPrice);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++)
		{
			sb.append(saleArr[i] + "\n");
		}
		return sb.toString();
	}
	
}












