import java.io.File;

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
		try {
			File f = new File(path);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
}
