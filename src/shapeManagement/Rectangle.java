package shapeManagement;

public class Rectangle extends Shape {

    private int width;
    private int height;
    protected static double totalSize = 0;
    protected static int totalCount = 0;

    public Rectangle(int id, int width, int height)
    {
        this.id = id;
        this.width = width;
        this.height = height;
        this.size = width * height;
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
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    public String toString()
    {
        return "Rectangle "+"("+id+", "+width+", "+height+", "+size+")";
    }
    
    public String getInfo()
    {
    	return "Rectangle," + id + "," + width + "," + height + "," + size;
    }
}

