
public class myStringOperations {


	public static String myUppercase(String text) {		
		return text.toUpperCase();
	}
	
	
	public static String myLowercase(String text) {		
		return text.toLowerCase();
	}
	
	
	public static String myConcat(String text, String append) {
		return text.concat(append);
	}
	
	
	public static int myLocate(String text, String find) {
		return text.indexOf(find);
	}
	
	
	public static String myHashTag(String text) {
		int start = text.indexOf("     "),
			end = text.lastIndexOf("     ");
		
		if ((start == -1 || end == -1) || start == end) {
			return "Error: Make sure to start with 5 spaces and end with 5 spaces.";
		}
		
		String str= text.substring(start, end + 5),
			output = "#" + myStringOperations.capitailizeWord(str).replace(' ', '_');
		
		return text.replace(str, output);
	}
	
	public static String capitailizeWord(String str) { 
		StringBuffer s = new StringBuffer();

		char ch = ' ';
		for (int i = 0; i < str.length(); i++) { 
			
			if (ch == ' ' && str.charAt(i) != ' ') 
				s.append(Character.toUpperCase(str.charAt(i))); 
			else
				s.append(str.charAt(i)); 
			ch = str.charAt(i); 
		}
		
		return s.toString().trim(); 
	}
	
}
