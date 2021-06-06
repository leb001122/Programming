package shapeManagement;

import java.io.File;
import java.io.IOException;

public class Problem10 {
	public static void main(String[] args) {
		ShapeManager sm = new ShapeManager();
		try {
			File file = new File(args[0]);
			if(!file.exists())
				file.createNewFile();
			
			sm.loadFile(file);
			sm.run();
			sm.saveFile(file);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
