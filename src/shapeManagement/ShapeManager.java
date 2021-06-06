package shapeManagement;

import java.io.*;
import java.util.Scanner;

public class ShapeManager {
    private ShapeList sList = new ShapeList();
        
    public void run()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	while(true)
    	{
    		System.out.print("> Select Menu (1. Input, 2. Delete, 3. Print, 4. Draw, 5. Sort, 6. Statistics, 7. Exit) ? ");
    		int menu = sc.nextInt();
    		if(menu == 7) 
    			break;
    		sc.nextLine();
    		handleMenu(menu, sc);
    	}
    	sc.close();
    }

    public void handleMenu(int menu, Scanner sc)
    {
    	switch(menu)
    	{
    	case 1 : input(sc); break;
    	case 2 : delete(sc); break;
    	case 3 : print(); break;
    	case 4 : draw(sc); break;
    	case 5 : sort(); break;
    	case 6 : statistics(); 
    		
    	}
    }
    
    public void loadFile(File file)
    {
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(file));
    		String line;
    		
    		while((line = br.readLine()) != null)
    			input(line);
    			br.close();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	System.out.println("> Loaded from objects.txt");
    }

    public void saveFile(File file)
    {
    	try {
    		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    		bw.write(sList.getInfo());
    		bw.close();
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
        System.out.println("> Saved to objects.txt");
    }
    
    
    public int input(String line)
    {
    	String [] strArray = line.split(",");
    	
    	int tmp = -1;
    	switch(strArray[0])
    	{
			case "Triangle" : 
				tmp = sList.input(new Triangle(Integer.parseInt(strArray[1]), Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3])));
				break;
			case "Rectangle" : 
				tmp = sList.input(new Rectangle(Integer.parseInt(strArray[1]), Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3])));
				break;
			case "Circle" : 
				tmp = sList.input(new Circle(Integer.parseInt(strArray[1]), Integer.parseInt(strArray[2])));
    	}
    	return tmp;
    }
    
    public void input(Scanner sc)
    {
    	System.out.print("> Select Object (1. Triangle, 2. Rectangle, 3. Circle) ? ");
    	int num = sc.nextInt();
    	sc.nextLine();
    	
    	int tmp = -1;
    	if(num == 1)
    	{
    		System.out.print("> Input Info (id, width, height) ? ");
    		tmp = input("Triangle," + sc.nextLine());
    	}  	
    	else if(num == 2)
    	{
    		System.out.print("> Input Info (id, width, height) ? ");
    		tmp = input("Rectangle," + sc.nextLine());
    	}
    	else if(num == 3)
    	{
    		System.out.print("> Input Info (id, radius) ? ");
    		tmp = input("Circle," + sc.nextLine());
    	}
    	if(tmp < 0)
    		System.out.println("> Error, Same ID exists");
    	else
            System.out.println("> OK");
    }
    
    public void delete(Scanner sc)
    {
    	System.out.print("> Input Info (id) ? ");
    	
    	if(sList.delete(sc.nextInt()) < 0)
    		System.out.println("> Error, ID does not exist");
    	else
    		System.out.println("> OK");
    }
    
    public void print()
    {
    	sList.printShapeList();
    }
    
    public void draw(Scanner sc)
    {
    	System.out.print("> Input Info (id) ? ");
    
    	if(sList.draw(sc.nextInt()) < 0)
    		System.out.println("> Error, ID does not exist");
    	else
    		System.out.println("> OK");
    }
    
    public void sort()
    {
    	sList.sort();
    	sList.printShapeList();
    }
    
    public void statistics()
    {
    	sList.printAvgSize();
    }
}





















