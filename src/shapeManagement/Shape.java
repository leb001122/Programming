package shapeManagement;

public class Shape {
	
    protected int id;
    protected double size;
    protected static double totalSize = 0;
    protected static int totalCount = 0;

    public int getId() { return id; }

    public double getSize() { return size; }

    public void setTotalSize(double size) { totalSize += size; }
    
    public void setTotalCount(int count) { totalCount += count; }
    
    public void draw() {}
    
    public String getInfo() { return ""; }
}
