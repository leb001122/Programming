package shapeManagement;

public class Triangle extends Shape {

    private int width;
    private int height;
    protected static double totalSize = 0;
    protected static int totalCount = 0;

    public Triangle(int id, int width, int height)
    {
        this.id = id;
        this.width = width;
        this.height = height;
        this.size = width * height * 0.5;
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
            {
            	if(i >= j)
            		System.out.print("*");
                else
                	System.out.print(" ");
            }
            System.out.println();
        }
    }

    public String toString()
    {
        return "Triangle "+"("+id+", "+width+", "+height+", "+size+")";
    }
    
    public String getInfo()
    {
    	return "Triangle," + id + "," + width + "," + height + "," + size;
    }
}
