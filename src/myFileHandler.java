import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
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

	public static boolean setPermission(String path) {
		
		try {
			File file = new File(path);
			
		    Set<PosixFilePermission> perms = new HashSet<>();
		    perms.add(PosixFilePermission.OWNER_READ);
		    perms.add(PosixFilePermission.OWNER_WRITE);
		    perms.add(PosixFilePermission.OWNER_EXECUTE);

		    perms.add(PosixFilePermission.OTHERS_READ);
		    perms.remove(PosixFilePermission.OTHERS_WRITE);
		    perms.add(PosixFilePermission.OTHERS_EXECUTE);

		    perms.add(PosixFilePermission.GROUP_READ);
		    perms.add(PosixFilePermission.GROUP_WRITE);
		    perms.add(PosixFilePermission.GROUP_EXECUTE);
		    Files.setPosixFilePermissions(file.toPath(), perms);
		    return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
}
