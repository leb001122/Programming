package foodSale;

import java.io.*;
import java.util.Scanner;

public class FoodSaleManager {
	private SaleList sList = new SaleList();
	private FoodList fList = new FoodList();
	private PersonList pList = new PersonList();
	
	public void run()
	{
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.print("> 1. 관리모드 2. 판매모드 3. 종료 ? ");
			int menu = sc.nextInt();
			if(menu == 1) // 관리모드
			{
				while(true)
				{
					System.out.print("> 1. 사람관리 2. 음식관리 3. 판매관리 4. 이전단계 ? ");
					menu = sc.nextInt();
					if(menu == 1) // 관리 - 사람관리
					{
						while(true)
						{
							System.out.print("> 1. 사람등록 2. 사람삭제 3. 사람출력 4. 이전단계 ? "); 
							menu = sc.nextInt();
							if(menu == 1) 
							{
								sc.nextLine();
								System.out.print("> Input Person (Name, Phone number) ? ");
								inputPerson(sc.nextLine());
							}
							else if(menu == 2)
							{
								sc.nextLine();
								System.out.print("> Delete Person (Name) ? ");
								deletePerson(sc.nextLine());
							}
							else if(menu == 3)
							{
								pList.printPList();
							}
							else 
								break;
						}
						
					}
					else if(menu == 2) // 관리 - 음식관리
					{
						while(true)
						{
							System.out.print("> 1. 음식등록 2. 음식삭제 3. 음식출력 4. 이전단계 ? ");
							menu = sc.nextInt();
							if(menu == 1)
							{
								sc.nextLine();
								System.out.print("> Input Food (Name, Price) ? ");
								inputFood(sc.nextLine());
							}
							else if(menu == 2)
							{
								sc.nextLine();
								System.out.print("> Delete Food (Name) ? ");
								deleteFood(sc.nextLine());
							}
							else if(menu == 3)
							{
								 fList.printFList();
							}
							else 
								break;
						}
					}
					else if(menu == 3) // 관리 - 판매관리
					{
						while(true)
						{
							System.out.print("> 1. 음식별 판매통계 2. 사람별 판매통계 3. 사람별 구매통계 4. 이전단계 ? ");
							menu = sc.nextInt();
							if(menu == 1) 
							{
								sList.food_saleStatistics();
							}
							else if(menu == 2)
							{
								sList.person_saleStatistics();
							}
							else if(menu == 3)
							{
								sc.nextLine();
								System.out.print("> Select Person (Name) ? ");
								sList.person_purchaseStatistics(sc.nextLine());
							}
							else 
								break;
						}
					}
					else // 관리모드 이전단계
						break;
				}
			}
			else if(menu == 2) // 판매모드
			{
				while(true)
				{
					System.out.print("> 1. 음식판매 2. 이전단계 ? ");
					menu = sc.nextInt();
					if(menu == 1) 
					{
						sc.nextLine();
						System.out.print("> Input Info (Person, Food, Number) ? ");
						inputInfo(sc.nextLine());
					}
					else 
						break;
				}
			}
			else  // 종료
				break;
		}
	}

	public void saveFile(File pf, File ff, File sf)
	{
		try {
			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter(pf));
			bw.write(pList.toString());
			bw.close();
			bw = new BufferedWriter(new FileWriter(ff));
			bw.write(fList.toString());
			bw.close();
			bw = new BufferedWriter(new FileWriter(sf));
			bw.write(sList.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 		
		System.out.println("> File saving completed");
	}

	public void loadFile(File pf, File ff, File sf)
	{
		try {
			BufferedReader br;
			
			br = new BufferedReader(new FileReader(pf));
			String line;
			while((line = br.readLine()) != null)
			{	String [] str = line.split(",");
				pList.add(new Person(str[0], str[1].trim()));
			}
			br.close();
			
			br = new BufferedReader(new FileReader(ff));
			while((line = br.readLine()) != null)
			{	String [] str = line.split(",");
				fList.add(new Food(str[0], Integer.parseInt(str[1].trim())));
			}
			br.close();
			
			br = new BufferedReader(new FileReader(sf));
			while((line = br.readLine()) != null)
			{	String [] str = line.split(",");
				Person person = pList.getPerson(str[0]);
				Food food = fList.getFood(str[1]);
				sList.add(new Sale(person, food, Integer.parseInt(str[2])));
			}
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("> File loading completed");
		
	}

	void inputPerson(String line)
	{
		String [] str = line.split(",");
		
		if(pList.add(new Person(str[0], str[1])) > 0)
			System.out.println("> OK");
		else
			System.out.println("> Error, " + str[0] + " is in-use");
	}
	
	void inputFood(String line)
	{
		String [] str = line.split(",");
		
		if(fList.add(new Food(str[0], Integer.parseInt(str[1]))) > 0)
			System.out.println("> OK");
		else
			System.out.println("> Error, " + str[0] + " is in-use");
	}
	
	void deletePerson(String name)
	{
		if(pList.delete(name) > 0)
			System.out.println("> OK");
		else 
			System.out.println("> Error, " + name + " is not registered");
	}
	
	void deleteFood(String name)
	{
		if(fList.delete(name) > 0)
			System.out.println("> OK");
		else 
			System.out.println("> Error, " + name + " is not registered");
	}
	
	void inputInfo(String line) // 판매
	{
		String [] str = line.split(",");
		
		Person person = pList.getPerson(str[0]);
		if(person == null)
		{
			System.out.println("> Error, " + str[0] + " is not registered");
			return;
		}

		Food food = fList.getFood(str[1]);
		if(food == null)
		{
			System.out.println("> Error, " + str[1] + " is not registered");
			return;
		}
		
		sList.add(new Sale(person, food, Integer.parseInt(str[2])));
		System.out.println("> OK");
	}
}
















