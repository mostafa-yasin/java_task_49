import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class myFileHandler {

	static public boolean create(String path) { 
		try {
			File f = new File(path);
			return f.createNewFile();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	static public boolean delete(String path) {
		try {
			File f = new File(path);
			return f.delete();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static String read(String path) {
		String output = "";
		String sCurrentLine;

		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			while ((sCurrentLine = br.readLine()) != null) {
				output += sCurrentLine + "\n";
			}
			
			fr.close();
			br.close();
			return output;
			
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean write(String path, String text) {
    
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	 	    writer.write(text);
	 	    writer.close();
	 	    return true;
		} catch (Exception e) {
			return false;
		}
	   
	}
}
