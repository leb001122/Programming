package shapeManagement;

public class Circle extends Shape{
	
    private int radius;
    protected static double totalSize = 0;
    protected static int totalCount = 0;

    public Circle(int id, int radius) //부모 변수 -> private
    {
        this.id = id;
        this.radius = radius;
        this.size = radius * radius * 3.14;
    }
    
    public void setTotalSize(double size) 
    {
    	super.setTotalSize(size);
    	totalSize += size; 
    }
    
    public void setTotalCount(int count) 
    { 
    	super.setTotalCount(count);
    	totalCount += count; 
    }

    public void draw()
    {        
        for(int i = -radius; i <= radius; i++)
        {
        	for(int j = -radius; j <= radius; j++)
        	{
        		if(i * i + j * j <= radius * radius)
        			System.out.print("*");
        		else
        			System.out.print(" ");
        	}
        	System.out.println();
        }
    }

    public String toString()
    {
        return "Circle "+"("+id+", "+radius+", "+size+")";
    }
    
    public String getInfo()
    {
    	return "Circle," + id + "," + radius + "," + size;
    }
}








