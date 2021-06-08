package foodSale;

import java.io.File;
import java.io.IOException;

public class FoodSaleApp {

	public static void main(String[] args) {
		
		FoodSaleManager fm = new FoodSaleManager();
		try {
			File pFile = new File(args[0]);
			if(!pFile.exists())
				pFile.createNewFile();
			File fFile = new File(args[1]);
			if(!fFile.exists())
				fFile.createNewFile();
			File sFile = new File(args[2]);
			if(!sFile.exists())
				sFile.createNewFile();
			
			fm.loadFile(pFile, fFile, sFile);
			fm.run();
			fm.saveFile(pFile, fFile, sFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

