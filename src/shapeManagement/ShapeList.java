package shapeManagement;

public class ShapeList {
    private Shape [] sList;
    private int size;

    public ShapeList()
    {
        sList = new Shape[100];
        size = 0;
    }

    public int search(int id)
    {

        for(int i = 0; i < size; i++)
        {
            if(sList[i].getId() == id)
                return i;
        }
        return -1;
    }

    public int input(Shape newShape)
    {
    	if(search(newShape.getId()) > -1)
    		return -1;
    	
        if(size == sList.length)
            throw new IndexOutOfBoundsException();

        sList[size] = newShape;
        size++;
        
        newShape.setTotalCount(1);
        newShape.setTotalSize(newShape.getSize());
        
        return 1;
    }

    public int delete(int id)
    {
        int idx = search(id);

        if(idx < 0)
        	return -1;
        
        sList[idx].setTotalCount(-1);
        sList[idx].setTotalSize(-sList[idx].getSize());
        
        if(idx == size-1) // element가 하나 밖에 없거나 제일 뒤의 원소 삭제 시
            sList[idx] = null;
        else               // 삭제되는 element의 인덱스에 제일 뒤 원소 삽입
            sList[idx] = sList[size-1];
        size--;
        
        return 1;
    }

    public int draw(int id)
    {
        int idx = search(id);
        
        if(idx < 0)
        	return -1;
        
        sList[idx].draw(); 
        
        return 1;
    }
    
    public void sort()
    {
    	Shape tmp;
    	for(int i = 0; i < size; i++)
    	{
    		for(int j = size-1; j > i; j--)
    		if(sList[i].getSize() > sList[j].getSize())
    		{
    			tmp = sList[i];
    			sList[i] = sList[j];
    			sList[j] = tmp;
    		}
    	}
    }

    public void printAvgSize() 
    {
        System.out.printf("> # of Objects = %d, Average size of Objects = %f \n",
        		Shape.totalCount, Shape.totalSize / Shape.totalCount);
        
        System.out.printf("> # of Triangles = %d, Average size of Objects = %f \n", 
        		Triangle.totalCount, Triangle.totalSize / Triangle.totalCount);
        
        System.out.printf("> # of Rectangles = %d, Average size of Objects = %f \n", 
        		Rectangle.totalCount, Rectangle.totalSize / Rectangle.totalCount);
        
        System.out.printf("> # of Circles = %d, Average size of Objects = %f \n", 
        		Circle.totalCount, Circle.totalSize / Circle.totalCount);
    }

    public void printShapeList()
    {
        for(int i = 0; i < size; i++)
        	System.out.println("> "+sList[i].toString());
    }
    
    public String getInfo()
    {
    	String str = "";
    	for(int i = 0; i < size; i++)
    		str += sList[i].getInfo() + "\n";
    	
    	return str;
    }
}











